package pers.kkddyz.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 用于记录日志的工具类
 * 提供公共的代码
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知");
    }


    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("后置通知");
    }


    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知");
    }


    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知");
    }

    /**
     * 环绕通知
     * 一个顶四个,只需要明确切入点位置,然后就可以调用上面四个通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {

        Object returnValue = null;
        // 明确调用业务层方法(即切入点方法)
        try {
            // 前置通知
            beforePrintLog();

            // 使用ProceedingJoinPoint执行切入点方法
            Object[] args = pjp.getArgs();
            returnValue = pjp.proceed(args);

            // 后置通知
            afterReturningPrintLog();
            return returnValue;
        } catch (Throwable throwable) {
            // 异常通知
            afterThrowingPrintLog();
            return returnValue;
        } finally {
            // 最终通知
            afterPrintLog();
        }

    }

}
