package pers.kkddyz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.service.IAccountService;

@Component("accountService")
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao1")
    //@Resource(name = "accountDao1")
    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
