package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author WangYao
 * @date 2020/2/28
 * @function
 */
public class Run {
    public static void main(String[] args) {
        try {
            Connection con = Mysql.getConnection();
            /*
             * 事务:
             * setAutoCommit()
             * commit()
             * rollback()
             */
            Statement s = con.createStatement();//环境  preparedStatement()
            String sql = "select * from book";
            ResultSet r = s.executeQuery(sql);
            /*
             * execute
             * executeQuery DQL 返回resultset
             * executeUpdate DML DDL 返回影响的行数
             */
            while(r.next()){
                System.out.println(r.getString("bname"));
            }
            int x = s.executeUpdate("update book set bname = '走进科学1' where bname = '走进科学1' ");
            System.out.println(x);

            Mysql.close(con,s,r);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
