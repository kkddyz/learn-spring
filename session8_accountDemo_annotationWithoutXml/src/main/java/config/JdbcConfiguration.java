package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author kkddyz
 * @date 2022/5/18
 * @description
 */
@PropertySource("classpath:jdbc.properties")
public class JdbcConfiguration {

    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;


    /**
     * 创建数据源对象 -- 使用成员变量
     */
    @Bean(name = "ds1")
    public DataSource createDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(this.driverClass);
            ds.setJdbcUrl(this.jdbcUrl);
            ds.setUser(this.user);
            ds.setPassword(this.password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
}