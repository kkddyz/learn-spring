package pers.kkddyz.utils;

/**
 * @author pers.pers.kkddyz
 *
 * 用于记录日志的工具类
 * 提供公共的代码
 */
public class Logger {

    /**
     * 用于打印日志到控制台,并且计划在业务层方法(切入点)前执行
     */
    public void printLog(){
        System.out.println("开始记录日志");
    }
}
