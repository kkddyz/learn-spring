package pers.kkddyz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pers.kkddyz.dao.IAccountDao;
import pers.kkddyz.service.IAccountService;

import javax.annotation.Resource;

/**
 * @author pers.pers.kkddyz
 * <p>
 * <p>
 * 账户操作业务实现
 * 曾经的xml配置:
 * <bean // Ioc配置
 * id="accountService"
 * class="pers.pers.pers.kkddyz.service.impl.AccountServiceImpl"
 * scope="" // 作用域
 * init-method=""
 * destory-method=""// 生命周期
 * >
 * <property // DI配置
 * name=""  // 属性名
 * value="" // 取值
 * >
 * </property>
 * </bean>
 * <p>
 * 对应的注解配置
 * 创建对象 -- 对应<bean></bean>
 * - @Component : 被注解类存入容器
 * - value属性指定id
 * - 默认值为当前类名(首字母小写)
 * - 用于三层架构以外的对象
 * <p>
 * 三个由component衍生的注解
 * - @Controller   -- 表现层
 * - @Service      -- 业务层
 * - @Repository   -- 持久层
 * - 这三个注解的作用和@Component是一样的。是spring提供的用于三层架构。
 * <p>
 * 注入数据 -- 对应 <property></property>
 * @Autowired : 自动按照类型注入Bean
 * - 直接注解在变量上，不需要setter()；
 * - 如果容器中没有类型的匹配项（接口类型可以匹配搭配容器中的接口实现类，这是多态），则会报错。
 * - 如果此时容器中存在多个接口实现类，即冲突的时候，会根据变量名去匹配Ioc容器中的id.
 * - 需要实现类1时变量名为var1,需要实现类2时变量名为var2
 * - 当实现类改变时，需要修改源码，肯定是不行的。
 * @Qualifier : 在@Autowired的基础上在按照名称注入
 * - 不可以单数单独用于成员变量，但是可以用于方法（因为方法标签中会指定参数类型）
 * - value : 指定bean id ,这样变量名就不会修改；需要修改的时该注解的value
 * @Resource : 直接按照bean id注入
 * - 可以单独对变量使用
 * - name指定 beanId
 * <p>
 * 以上三个注解均用于注入bean，而基本类型和String不行。
 * 此外，集合类型的注入只能使用xml实现，
 * @Value ： 注入基本类型和String
 * - value : 指定数据的值
 * - 可以使用spring中的SpEL
 * - SpEl写法: ${表达式}
 * <p>
 * 改变作用范围 - 对应scope标签
 * - value : 指定作用范围
 * - singleton 默认值
 * - prototype
 * <p>
 * 声明周期相关 -- 仅作了解
 * @PreDestory -- 指定销毁方法
 * @PostContrust -- 指定初始化方法
 * <p>
 * - 注解在方法上，类似于init(),destroy();
 */
@Component("accountService")
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {

    /*
        自动按照类型注入，而不是根据变量名（容器中存入的对象id为accountDao,没有1）
        直接到容器中寻找类型为IAccountDao的对象，不管key.

        使用@Qualifier，指定bean id
     */

    @Autowired
    @Qualifier("accountDao1")
    //@Resource(name = "accountDao1")
    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
