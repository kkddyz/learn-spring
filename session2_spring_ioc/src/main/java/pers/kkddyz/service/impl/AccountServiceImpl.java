package pers.kkddyz.service.impl;


import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.dao.impl.AccountDaoImpl;
import pers.kkddyz.service.IAccountService;

/**
 * @author pers.pers.kkddyz
 * 账户操作业务实现
 */
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        IAccountDao accountDao = new AccountDaoImpl();
        accountDao.saveAccount();
    }
}
