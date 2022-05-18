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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        // 从容器中获取bean对象 第二个参数用于转型,不传就自己强转
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        accountService.saveAccount();
    }
}
