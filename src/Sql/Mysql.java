package Sql;

import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
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
            Class.forName(driver);//sql5后可以不写,可以自动注册驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection con, Statement sta, ResultSet res){//等会使用lombok的@nonNull    变成null让垃圾回收工作
        try {
            if(con != null){
                con.close();
                con = null;
            }
            if(sta != null){
                sta.close();
                sta = null;
            }
            if(res != null){
                res.close();
                res = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
