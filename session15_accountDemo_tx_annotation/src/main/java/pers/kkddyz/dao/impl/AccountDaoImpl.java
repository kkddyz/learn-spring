package pers.kkddyz.dao.impl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;
import pers.kkddyz.utils.ConnectionUtils;

import java.util.List;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 账户的持久层实现类，使用JdbcTemplate
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    @Autowired
    private ConnectionUtils connectionUtils;


    @Override
    public Account findAccountByName(String accountName) {
        String sql = "select * from account where name = ?";

        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(), sql,
                    new BeanListHandler<>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            } else if (accounts.size() == 1) {
                return accounts.get(0);
            } else {
                throw new RuntimeException("存在多个同名账户");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set name = ?,money = ? where id = ?";

        try {
            runner.update(connectionUtils.getThreadConnection(),
                    sql, account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

