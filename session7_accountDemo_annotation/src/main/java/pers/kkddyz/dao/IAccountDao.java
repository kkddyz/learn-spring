package pers.kkddyz.dao;

import pers.kkddyz.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询
     */
    Account findAccountById(Integer id);

    /**
     * 保存
     */
    void saveAccount(Account account);

}
