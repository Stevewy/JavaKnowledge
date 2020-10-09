package test;

import java.sql.*;

/**
 * @author WangYao
 * @date 2020/10/6
 * @function 测试连接docker里面的mysql
 */
public class Test1 {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:13306/Library"; //忘了docker我设置的端口不一样..
        String user = "root";
        String password = "root";
        //Class.forName(driver);//sql5后可以不写,可以自动注册驱动
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from book");
            while(r.next()){
                System.out.println(r.getInt("id") + ": " + r.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
