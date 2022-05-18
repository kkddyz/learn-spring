package pers.kkddyz.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 一个创建bean的工厂
 * bean: 可重用组件
 * JavaBean(使用java语言的bean对象) != 实体类
 * - javabean包含实体类
 * - 可重用组件除了实体类,还包括service,dao
 * <p>
 * 使用prop配置文件,通过反射创建bean对象
 */
public class BeanFactory {


    private static Properties props;

    /**
     * map容器 存放bean对象
     */
    private static Map<String, Object> beans;

    // 静态代码块
    static {
        try {
            // 读取配置
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props = new Properties();
            props.load(in);

            // 实例化容器
            beans = new HashMap<>();

            // 创建所有bean对象,get()只是返回容器对象,而不是创建对象
            Enumeration<Object> propKeys = props.keys();

            // keys时是配置文件中类的缩写
            while (propKeys.hasMoreElements()) {
                // 1. 获取propKey
                String propKey = propKeys.nextElement().toString();

                // 2. 获取全类名
                String className = props.getProperty(propKey);


                // 3. 创建对象
                Object bean = null;
                try {
                    bean = Class.forName(className).newInstance();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                // 4. 放入容器
                beans.put(propKey, bean);
            }

        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }


    }

    /**
     * 通过beanName获取bean对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {

        return beans.get(beanName);
    }

}
