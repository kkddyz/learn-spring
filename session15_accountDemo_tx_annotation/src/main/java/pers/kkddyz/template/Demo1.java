package pers.kkddyz.template;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pers.kkddyz.domain.Account;


/**
 * @author pers.pers.kkddyz
 * @date 2022/5/17
 * @description 使用Spring内置数据源创建JdbcTemplate
 */
public class Demo1 {

    public static void main(String[] args) {
        // spring内置数据源 -- 设置参数
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/learn_c3p0");
        ds.setUsername("root");
        ds.setPassword("123456");

        // 创建JdbcTemplate
        JdbcTemplate jt = new JdbcTemplate(ds);


        // 使用JdbcTemplate执行SQL()
        Account account = jt.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class),1);
        System.out.println(account);

    }
}
