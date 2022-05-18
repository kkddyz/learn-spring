package pers.kkddyz.dao.impl;


import org.springframework.stereotype.Repository;
import pers.kkddyz.dao.IAccountDao;

/**
 * @author pers.pers.kkddyz
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存账户信息到数据库222222222222222");
    }
}
