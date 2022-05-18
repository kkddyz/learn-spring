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
