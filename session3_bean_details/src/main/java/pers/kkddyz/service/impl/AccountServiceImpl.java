package pers.kkddyz.service.impl;


import pers.kkddyz.service.IAccountService;

/**
 * @author pers.pers.kkddyz
 * 账户操作业务实现
 */
public class AccountServiceImpl implements IAccountService {

    /**
     * no args constructor
     */
    public AccountServiceImpl(){
        System.out.println("无参构造器,创建了accountService对象");
    }

    public AccountServiceImpl(String s){
        System.out.println("含参构造器,创建了accountService对象");
    }

    @Override
    public void saveAccount() {
        System.out.println("执行service的saveAccount方法");
    }
}
