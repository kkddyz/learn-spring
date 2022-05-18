package pers.kkddyz.dao.impl;

import pers.kkddyz.dao.IAccountDao;

/**
 * @author pers.pers.kkddyz
 *
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存账户信息到数据库");
    }
}
