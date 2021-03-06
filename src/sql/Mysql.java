package sql;

import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author WangYao
 * @date 2020/2/27
 * @function jdbc工具类
 */
public final class Mysql {
    //分开可以只加载一次,得到多个连接
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Connection con = null;

    static{
        InputStream resourceAsStream = Mysql.class.getClassLoader().getResourceAsStream("sql/db.properties");

        Properties p = new Properties();
        try {
            p.load(resourceAsStream);//不使用类加载器,可以使用FileReader来读取文件(注意,要使用绝对路径),但明显类加载器要好
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
        if(con == null)
            return con = DriverManager.getConnection(url, user, password);
        else
            return con;
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

    public static void close(Connection con, Statement sta){
        close(con, sta, null);
    }

    public static boolean rollback(Connection con){
        if(con != null){
            try {
                con.rollback();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }
}
