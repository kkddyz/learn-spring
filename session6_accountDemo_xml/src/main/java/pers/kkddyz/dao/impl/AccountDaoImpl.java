package pers.kkddyz.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 账户的持久层实现类，使用dbtuils
 */
public class AccountDaoImpl implements IAccountDao {


    QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        try {
            List<Account> accounts = runner.query(sql, new BeanListHandler<>(Account.class));
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        String sql = "select * from account where id = ?";
        Account account = null;
        try {
            account = runner.query(sql, new BeanHandler<>(Account.class), id);
            return account;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Override
    public void saveAccount(Account account) {

        String saveAccountSql = "insert into account(name,money) values(?,?)";
        String name = account.getName();
        Float money = account.getMoney();
        try {
            runner.update(saveAccountSql, name, money);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}

