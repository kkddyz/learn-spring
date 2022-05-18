package pers.kkddyz.service.impl;

import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.domain.Account;
import pers.kkddyz.service.IAccountService;
import pers.kkddyz.utils.TransactionManager;

import java.util.List;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 业务层实现类
 *
 * 事务控制应该在业务层，也就是说一个service函数使用一个conn对象
 * 而之前，事务控制在持久层，即一个dao函数使用一个conn对象
 *
 *
 *
 */
public class AccountServiceImpl implements IAccountService {


    /**
     * queryRunner为多例对象，每次的dao执行的操作使用的都是不同的connection对象 使得
     */
    private IAccountDao accountDao;

    /**
     * 通过TransManager对象实现对业务层的事务控制
     */
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    /**
     * 对该操作实现事务控制
     * 实现事务控制的前提是，manager必须有操作使用的conn引用
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, float money) {
        // source --> target  source钱变少 target钱变多

        try{
            // 1. 开启事务
            transactionManager.beginTransaction();
            // 2. 执行操作

            // 2.1 查询转入，转出账户
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);

            // 2.2 修改两个账户金额
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);

            // 2.3 更新
            accountDao.updateAccount(source);

            // 设置异常，使得 source更新，target，不能更新。
            int a = 1/0;
            // 发现事务被回滚 金额没有改变

            accountDao.updateAccount(target);

            // 3. 提交事务
            transactionManager.commit();

            // 4. 返回结果

        }catch (Exception e){

            // 回滚
            transactionManager.rollback();
            // 打印异常
            e.printStackTrace();
        }finally {

            // 释放连接
            transactionManager.release();
        }
    }
}
