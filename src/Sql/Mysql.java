package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author WangYao
 * @date 2020/2/27
 * @function
 */
public class Mysql {
    public static void main(String[] args) {
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/Library";
        String user="root";
        String password="wangyao";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();
            String sql = "CREATE TABLE book(\n" +
                    "\tid INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "\tbname VARCHAR(20) NOT NULL,\n" +
                    "\tprice DOUBLE CHECK(price BETWEEN 0 AND 100),\n" +
                    "\tauthor VARCHAR(20) DEFAULT '佚名',\n" +
                    "\tpublishDate DATETIME\n" +
                    ");";
            ResultSet resultSet = statement.executeQuery(sql);
            /*String name;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                System.out.println("姓名：" + name);
            }*/
            resultSet.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
    }
}
