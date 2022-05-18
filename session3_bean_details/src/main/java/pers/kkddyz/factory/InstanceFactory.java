package pers.kkddyz.factory;

import pers.kkddyz.service.IAccountService;
import pers.kkddyz.service.impl.AccountServiceImpl;

/**
 * @author pers.pers.kkddyz
 *
 * 模拟一个工厂类,在实际使用时可能存在于某个jar包中
 */
public class InstanceFactory {

    public IAccountService getAccountService(){
        System.out.println("工厂方法创建service");
        return new AccountServiceImpl("Test");
    }
}
