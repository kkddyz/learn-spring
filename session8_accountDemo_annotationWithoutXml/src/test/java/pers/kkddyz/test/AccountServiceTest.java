package pers.kkddyz.test;

import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.kkddyz.domain.Account;
import pers.kkddyz.service.IAccountService;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {


    @Autowired
    private IAccountService service;

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("testAccount");
        account.setMoney(2000F);
        service.saveAccount(account);
    }

    // 其他DML就不测试了

    @Test
    public void testQueryById() {
        Account account = service.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = service.findAllAccount();

        System.out.println(accounts);
    }

    /**
     * 手动创建ApplicationContext，通过AnnotationConfigApplicationContext。
     */
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        List<Account> accounts = service.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
