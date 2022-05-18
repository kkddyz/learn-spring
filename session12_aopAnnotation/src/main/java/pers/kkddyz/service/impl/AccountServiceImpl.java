package pers.kkddyz.service.impl;

import org.springframework.stereotype.Service;
import pers.kkddyz.service.IAccountService;

/**
 * @author pers.pers.kkddyz
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存账户");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新账户");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除账户");
        return 0;
    }
}
