package spi;

import com.mysql.cj.jdbc.NonRegisteringDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author labvi
 * @version 1.0.0
 */
public class MyDriver extends NonRegisteringDriver implements Driver {

    static {
        try {
            java.sql.DriverManager.registerDriver(new MyDriver());
        } catch (SQLException e) {
            throw new RuntimeException("Can't register driver");
        }
    }

    /**
     * Construct a new driver and register it with DriverManager
     *
     * @throws SQLException if a database error occurs.
     */
    public MyDriver() throws SQLException {
    }

    public Connection connection(String url, Properties info) throws SQLException {
        System.out.println("准备创建数据库连接.url:"+url);
        System.out.println("JDBC配置信息："+info);
        info.setProperty("user", "root");
        Connection connection =  super.connect(url, info);
        System.out.println("数据库连接创建完成!"+connection.toString());
        return connection;
    }
}
