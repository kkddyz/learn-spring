package pers.kkddyz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.kkddyz.service.IAccountService;



/**
 * @author pers.pers.kkddyz
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    /**
     * 指定工厂类
     */
    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService service;

    @Test
    public void testTransfer(){
        service.transfer("account1","account2",200);
    }

}
