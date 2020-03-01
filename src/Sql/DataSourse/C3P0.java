package Sql.DataSourse;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author WangYao
 * @date 2020/2/29
 * @function c3p0数据库连接池
 */
public class C3P0 {

    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 10; i++) {
            Connection con = ds.getConnection();
            System.out.println(i + ": " + con);
        }

    }
}
