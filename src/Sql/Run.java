package Sql;

import java.sql.*;

/**
 * @author WangYao
 * @date 2020/2/28
 * @function jdbc运行类
 */
public class Run {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        String sql = "select * from book";
        try {
            con = Mysql.getConnection();
            con.setAutoCommit(false);
            p = con.prepareStatement("update book set number = number + ? where id = ?;");
            p.setInt(1,1);
            p.setInt(2,1);
            int flag = p.executeUpdate();
            con.commit();
            if(flag == 1)
                System.out.println("成功修改一行");
            else
                System.out.println("修改失败");
        } catch (Exception e) {
            Mysql.rollback(con);
        } finally {
            Mysql.close(con, p, r);
        }
    }

}
