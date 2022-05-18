package pers.kkddyz.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务管理的工具类
 *
 * @author kkddyz
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    /**
     * 使用工具类获取一个conn
     */
    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * 设置切入点表达式
     */
    @Pointcut("execution(* pers.kkddyz.service.impl.*.*(..))")
    private void pt1() {
    }


    /**
     * 开启事务
     */
    //@Before("pt1()")
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    //@AfterReturning("pt1()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    //@AfterThrowing("pt1()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    //@After("pt1()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close(); // 关闭连接
            connectionUtils.removeConnection(); // 解绑
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    /**
     * 环绕通知 : 手动配置通知
     */
    @Around("pt1()")
    public Object roundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        Object rtValue = null;
        try {
            // 1. 获取参数
            Object[] args = proceedingJoinPoint.getArgs();
            // 2. 开启事务
            this.beginTransaction();
            // 3. 执行方法
            rtValue = proceedingJoinPoint.proceed(args);
            // 4. 提交事务
            this.commit();
            // 5. 返回结果
            return rtValue;
        } catch (Throwable e) {
            // 回滚事务
            this.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放资源
            this.release();
        }
    }
}
