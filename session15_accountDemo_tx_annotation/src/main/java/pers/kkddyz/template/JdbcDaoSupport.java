package pers.kkddyz.template;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author pers.kkddyz
 * @date 2022/5/17
 * @description
 */
/**
 * @author pers.kkddyz
 *
 * 用于抽取dao中重复的部分: 注入template
 *
 * 通过继承使用这部分代码
 */
public class JdbcDaoSupport {

    /**
     * 直接注入Template
     */
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    /**
     * 通过datasource创建template
     */
    public void setDataSource(DataSource dataSource) {
        if (template == null){
            template = createTemplate(dataSource);
        }

    }

    private JdbcTemplate createTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
