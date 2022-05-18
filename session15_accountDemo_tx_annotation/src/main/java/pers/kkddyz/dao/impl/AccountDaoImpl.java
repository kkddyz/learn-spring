package pers.kkddyz.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;
import pers.kkddyz.template.JdbcDaoSupport;

import java.util.List;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 账户的持久层实现类，使用JdbcTemplate
 */
@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        List<Account> accounts = getTemplate().query(sql, new BeanPropertyRowMapper<>(Account.class));
        return accounts;
    }

    @Override
    public Account findAccountById(Integer id) {
        String sql = "select * from account where id = ?";
        Account account = getTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        String saveAccountSql = "insert into account(name,money) values(?,?)";
        String name = account.getName();
        Float money = account.getMoney();
        getTemplate().update(saveAccountSql, name, money);
    }

    @Override
    public Account findAccountByName(String accountName) {
        String sql = "select * from account where name = ?";

        try {
            List<Account> accounts = getTemplate().query(sql, new BeanPropertyRowMapper<>(Account.class),
                    accountName);
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
            getTemplate().update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

