package pers.kkddyz.service.impl;


import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;
import pers.kkddyz.service.IAccountService;


public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        // 1 查询转入，转出账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);

        // 2 修改两个账户金额
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        // 3 更新
        accountDao.updateAccount(source);

        // 设置异常，使得 source更新，target，不能更新。
        int a = 1/0;
        accountDao.updateAccount(target);
    }
}