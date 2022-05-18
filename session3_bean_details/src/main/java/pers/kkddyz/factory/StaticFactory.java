package pers.kkddyz.factory;

import pers.kkddyz.service.IAccountService;
import pers.kkddyz.service.impl.AccountServiceImpl;

/**
 * @author pers.pers.kkddyz
 */
public class StaticFactory {

    public static IAccountService getAccountService() {

        System.out.println("静态工厂创建service");
        return new AccountServiceImpl();
    }
}
