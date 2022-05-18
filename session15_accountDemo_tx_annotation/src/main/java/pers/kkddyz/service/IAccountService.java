package pers.kkddyz.service;


/**
 *  账户的业务层接口
 */
public interface IAccountService {

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
