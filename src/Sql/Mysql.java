package Sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author WangYao
 * @date 2020/2/27
 * @function
 */
public class Mysql {
    //分开可以只加载一次,得到多个连接
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static{
        InputStream resourceAsStream = Mysql.class.getClassLoader().getResourceAsStream("Sql/db.properties");

        Properties p = new Properties();
        try {
            p.load(resourceAsStream);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try {
            Connection con = Mysql.getConnection();
            Statement s = con.createStatement();//环境
            String sql = "select * from book";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                System.out.println(r.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
