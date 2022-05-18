package pers.kkddyz.dao;



import pers.kkddyz.domain.Account;

import java.util.List;

/**
 * The interface Account dao.
 *
 * @author pers.pers.kkddyz  <p> 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 根据用户名查询账户
     * @param accountName
     * @return 查询到唯一一个账户就返回，没有返回null,多个抛异常
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);
}