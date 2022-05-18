package pers.kkddyz.dao.impl;


import org.springframework.stereotype.Repository;
import pers.kkddyz.dao.IAccountDao;

/**
 * @author pers.pers.kkddyz
 */
@Repository("accountDao1")
public class AccountDaoImpl1 implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存账户信息到数据库111111111111111111");
    }
}
