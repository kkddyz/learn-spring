package pers.kkddyz.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;
import pers.kkddyz.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 账户的持久层实现类，使用dbtuils
 */
public class AccountDaoImpl implements IAccountDao {


    private QueryRunner runner;

    /**
     * 引用ConnectionUtils.getThreadConn()
     */
    private Connection connection;

    /**
     * 为什么我们将conn与thread绑定
     * 因为在service与它调用的dao方法是同一个线程。
     * 在整个service范围内，所有的dao都属于同一个线程。
     * 自然service管理的threadConn与dao使用的ThreadConn是相同的
     */
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;

        // 保存当前线程的conn到成员中，方便方法使用
        connection = connectionUtils.getThreadConnection();
    }

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        try {
            List<Account> accounts = runner.query(connection,sql, new BeanListHandler<>(Account.class));
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
            account = runner.query(connection,sql, new BeanHandler<>(Account.class), id);
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
            runner.update(connection,saveAccountSql, name, money);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        String sql = "select * from account where name = ?";

        try {
            List<Account> accounts = runner.query(connection,sql, new BeanListHandler<>(Account.class), accountName);
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
            runner.update(connection,sql,account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

