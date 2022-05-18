package pers.kkddyz.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;

import java.util.List;

/**
 * 账户的持久层实现类，使用JdbcTemplate,事务控制依赖与Spring提供的txmanager
 * 如何保证JdbcTemplate使用相同的conn??
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        List<Account> accounts = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Account.class));
        return accounts;
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set name = ?,money = ? where id = ?";

        try {
            getJdbcTemplate().update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        String sql = "select * from account where name = ?";

        try {
            List<Account> accounts = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Account.class), accountName);
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
}