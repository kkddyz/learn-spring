package pers.kkddyz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kkddyz
 */
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    @Autowired
    private final DataSource dataSource;

    public ConnectionUtils(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return 返回当前线程的连接
     */
    public Connection getThreadConnection() {

        // 1. 先从ThreadLocal中获取
        Connection connection = threadLocal.get();

        // 2. 如果有就直接返回
        if (connection != null) {
            return connection;
        } else {
            // 如果没有就从数据源获取一个连接,并且存入threadLocal(与线程绑定)
            try {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
                return connection;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }
    }


    /**
     * 将conn与线程解绑
     */
    public void removeConnection() {
        threadLocal.remove();
    }
}
