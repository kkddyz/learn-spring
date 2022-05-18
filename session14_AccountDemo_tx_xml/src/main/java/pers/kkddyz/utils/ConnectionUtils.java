package pers.kkddyz.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author pers.pers.kkddyz
 * <p>
 * 连接的工具类
 * 从数据源获取连接，并且实现与线程的绑定。
 * <p>
 * 到底什么叫与线程绑定 -- 设为threadLoacl
 * <p>
 * 我既然在使用ConnectionUtils，那么这个线程又在哪里，为什么不是ConnectionUtils的方法？？？
 * <p>
 * （为什么需要一个线程，线程从哪里开始，在哪里结束，线程的数据结构是什么，谁来管理线程）
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
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
     * 将conn与线程解绑,也就是清除threadLocal绑定的conn
     */
    public void removeConnection() {
        threadLocal.remove();
    }
}
