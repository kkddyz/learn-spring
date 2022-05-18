package pers.kkddyz.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.kkddyz.service.IAccountService;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 获取spring ioc核心容器
 */
public class Client {

    public static void main(String[] args) {

        // 创建核心容器对象
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean.xml");

        // 获取bean对象
        IAccountService accountService =
                applicationContext.getBean("accountService3", IAccountService.class);

        // 执行方法
        accountService.saveAccount();

    }
}
