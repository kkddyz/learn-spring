package pers.kkddyz.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.kkddyz.domain.Account;
import pers.kkddyz.service.IAccountService;

import java.util.List;


/**
 * @author pers.pers.kkddyz
 */
public class AccountServiceTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    private IAccountService service = (IAccountService) context.getBean("accountService");

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("testAccount");
        account.setMoney(2000F);
        service.saveAccount(account);
        System.out.println("end");
    }

    // 其他DML就不测试了

    @Test
    public void testQueryById(){
        Account account = service.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = service.findAllAccount();

        System.out.println(accounts);
    }


}
