package Sql.DataSourse;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author WangYao
 * @date 2020/3/1
 * @function druid数据库连接池工具类
 */
public class Druid {
    private static DataSource ds = null;

    static{
        Properties p = new Properties();

        try {
            InputStream is = Druid.class.getClassLoader().getResourceAsStream("Sql/Datasourse/druid.properties");
            p.load(is);
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDataSource(){
        return ds;
    }

}
