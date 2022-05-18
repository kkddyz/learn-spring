package pers.kkddyz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;
import pers.kkddyz.service.IAccountService;

import java.util.List;

/**
 * @author pers.pers.kkddyz
 *
 * 没有使用事务管理
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

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