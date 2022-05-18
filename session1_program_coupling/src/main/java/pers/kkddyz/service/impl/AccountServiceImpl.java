package pers.kkddyz.service.impl;

import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.factory.BeanFactory;
import pers.kkddyz.service.IAccountService;

/**
 * @author pers.pers.kkddyz
 * 账户操作业务实现
 */
public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
