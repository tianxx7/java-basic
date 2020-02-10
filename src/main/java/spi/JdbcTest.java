package spi;

import java.sql.*;
import java.util.Properties;

/**
 * @author labvi
 * @version 1.0.0
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connection = DriverManager.getConnection("jdbc:mysql://47.102.157.88:3306/template",properties);
        System.out.println(connection.getAutoCommit());
        String sql = "insert into user(username,password) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,"txx");
        preparedStatement.setString(2,"123456");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()){
            System.out.println(generatedKeys.getInt(1));
        }
        connection.close();
    }
}
