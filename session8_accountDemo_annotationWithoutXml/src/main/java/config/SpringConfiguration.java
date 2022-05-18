package config;

/**
 * @author kkddyz
 * @date 2022/5/18
 * @description
 */

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@ComponentScan("pers.kkddyz")
@Import(JdbcConfiguration.class)
public class SpringConfiguration {

    ///**
    // * 创建datasource的工厂方法 移入JdbcConfiguration
    // */
    //@Bean(name = "ds1")
    //public DataSource createDataSource() {
    //    ComboPooledDataSource ds = new ComboPooledDataSource();
    //
    //    // 使用类成员去创建bean对象dataSource
    //    try {
    //        // 将配置写死在代码中
    //        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
    //        ds.setJdbcUrl("jdbc:mysql://localhost:3306/learn_c3p0");
    //        ds.setUser("root");
    //        ds.setPassword("123456");
    //    } catch (PropertyVetoException e) {
    //        e.printStackTrace();
    //    }
    //
    //    return ds;
    //}


    /**
     * Sping会去寻找类型为DataSource,BeanId为"ds1"的bean对象
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(@Qualifier("ds1") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }


}
