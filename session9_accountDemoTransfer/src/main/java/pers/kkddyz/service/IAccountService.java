package pers.kkddyz.service;

import pers.kkddyz.domain.Account;

import java.util.List;

/**
 * The interface Account service.
 *
 * @author pers.pers.kkddyz <p> 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 查询所有
     *
     * @return list list
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     *
     * @param id the id
     * @return account account
     */
    Account findAccountById(Integer id);

    /**
     * 保存
     *
     * @param account the account
     */
    void saveAccount(Account account);


    /**
     * 添加一个新的业务
     * 实现转账业务
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName,String targetName,float money);



}
