package pers.kkddyz.jdbc;

import java.sql.*;

/**
 * @author pers.pers.kkddyz
 *
 * 编译期依赖
 *      耦合:程序界的依赖关系
 *          - 类的依赖
 *          - 方法的依赖
 *      解耦:降低程序间的依赖关系
 *
 *      实际开发中做到,编译期不依赖,.运行时才依赖
 *      解耦思路
 *          - 使用反射代替new
 *          - 从配置文件中读取反射创建的对象名
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws SQLException {
        // 0. 导入驱动jar包 注册驱动 -- mysql8不需要了
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver()) 编译器依赖


//      Class.forName("com.mysql.jdbc.Driver");
        // 这时候由于没有对应驱动发生的是运行时异常. 也就说我们把依赖从编译期转移到了运行时

        // 1. 获取连接对象
        String url = "jdbc:mysql://localhost:3306/learn_spring";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 2. 获取prepStatement
        String sql = "select * from account";
        PreparedStatement pstm = conn.prepareStatement(sql);


        // 3  执行查询 得到结果集
        ResultSet rs = pstm.executeQuery();

        // 4. 遍历结果集
        while (rs.next()) {
            // next 方法将结果集的当前行向后移动一行 (开始指向第0行) 如果不存在下一行 返回
            String string1 = rs.getString(1);
            String string2 = rs.getString(2);
            String string3 = rs.getString(3);

            System.out.println(string1);
            System.out.println(string2);
            System.out.println(string3);
        }

        System.out.println("----------------------------------------------------------------------------------");

        // 5. 释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}

