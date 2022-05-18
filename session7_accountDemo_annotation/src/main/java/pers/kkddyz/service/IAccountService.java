package pers.kkddyz.service;

import pers.kkddyz.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * 查询所有
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户
     */
    void saveAccount(Account account);
}
