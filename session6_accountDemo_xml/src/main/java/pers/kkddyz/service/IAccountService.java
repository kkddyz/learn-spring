package pers.kkddyz.service;

import pers.kkddyz.domain.Account;

import java.util.List;

/**
 * The interface Account service.
 *
 * @author pers.pers.kkddyz  <p> 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 查询所有
     *
     * @return list
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     *
     * @param id the id
     * @return account
     */
    Account findAccountById(Integer id);

    /**
     * 保存
     *
     * @param account the account
     */
    void saveAccount(Account account);


}
