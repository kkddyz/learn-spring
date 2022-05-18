package pers.kkddyz.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import pers.kkddyz.service.IAccountService;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 获取spring ioc核心容器
 */
public class Client {

    public static void main(String[] args) {

        // 1. 创建核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("F:\\JAVAEE_Workspace\\learnspring\\session2_spring_ioc\\src\\main\\resources\\bean.xml");

        // 2. 从容器中获取bean对象 传入参数用于转型,不传就自己强转
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        // 3. 测试service
        accountService.saveAccount();
    }
}
