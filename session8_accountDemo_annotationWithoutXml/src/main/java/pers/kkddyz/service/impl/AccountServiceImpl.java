package pers.kkddyz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;
import pers.kkddyz.service.IAccountService;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
}
