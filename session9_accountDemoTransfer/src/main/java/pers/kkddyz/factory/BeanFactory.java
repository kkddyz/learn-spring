package pers.kkddyz.factory;

import pers.kkddyz.service.IAccountService;
import pers.kkddyz.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 工厂类的作用是提供代理对象
 */
public class BeanFactory {

    /**
     * 被代理对象
     */
    private IAccountService accountService;

    /**
     * 通过被代理对象和事务控制器，实现增强
     */
    private TransactionManager transactionManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 获取service的代理对象
     * <p>
     * 由于是对原来方法的增强,所以原来的调用dao的操作都是Object returnValue = method.invoke(accountService, args);
     * 我们只需要添加事务管理代码即可.
     */
    public IAccountService getAccountServiceProxy() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        try {
                            // 1. 开启事务
                            transactionManager.beginTransaction();
                            // 2. 执行操作
                            Object returnValue = method.invoke(accountService, args);
                            // 3. 提交事务
                            transactionManager.commit();
                            // 4. 返回结果
                            return returnValue;
                        } catch (Exception e) {
                            // 回滚
                            transactionManager.rollback();
                            // 抛出异常(不然就得在这里返回null)
                            throw new RuntimeException(e);
                        } finally {
                            // 释放连接
                            transactionManager.release();
                        }
                    }
                });
    }
}
