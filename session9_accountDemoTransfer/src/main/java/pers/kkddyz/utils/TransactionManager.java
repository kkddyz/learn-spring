package pers.kkddyz.utils;

import java.sql.SQLException;

/**
 * @author pers.pers.kkddyz
 *
 * 首先需要获取当前线程的conn
 *
 * 事务管理的工具类
 *  1. 开启事务
 *  2. 提交事务
 *  3. 回滚事务
 *  4. 释放资源
 *
 *  封装的作用是什么？
 *  在线程池获取conn对象基础上，保证在一个业务中可以一直使用一个conn(分析一下是如何实现的 )
 */
public class TransactionManager {

    /**
     * 使用工具类获取一个conn
     */
    private ConnectionUtils connectionUtils;

    /**
     * property标签注入
     */
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务 关闭自动提交,目的是什么,手动实现事务管理
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    /**
     * 释放资源
     */
    public void release(){
        try {
            connectionUtils.getThreadConnection().close(); // 关闭连接
            connectionUtils.removeConnection(); // 解绑
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }



}
