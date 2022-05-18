package pers.kkddyz.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    QueryRunner runner;


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

