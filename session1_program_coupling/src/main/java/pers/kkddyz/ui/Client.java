package pers.kkddyz.ui;

import pers.kkddyz.factory.BeanFactory;
import pers.kkddyz.service.IAccountService;

/**
 * 模拟一个表现层,用于调用业务层
 * 表现层 --> 业务层 --> 持久层（没写控制器）
 */
public class Client {

    public static void main(String[] args) {
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
