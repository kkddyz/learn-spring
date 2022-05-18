package pers.kkddyz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.kkddyz.service.IAccountService;

/**
 * @author pers.pers.kkddyz
 */
public class TestAop {

    public static void main(String[] args) {

        // 1. 获取容器
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取方法
        IAccountService service = (IAccountService) ac.getBean("accountService");
        // 3. 测试service
        service.saveAccount();
        service.updateAccount(1);
        service.deleteAccount();


    }
}
