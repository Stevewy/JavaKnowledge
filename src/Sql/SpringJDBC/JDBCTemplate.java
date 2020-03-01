package Sql.SpringJDBC;

import Sql.DataSourse.Druid;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author WangYao
 * @date 2020/3/1
 * @function
 */
public class JDBCTemplate {

    public static void main(String[] args) {
        JdbcTemplate t = new JdbcTemplate(Druid.getDataSource());
        String sql = "select * from book;";
        List<Map<String,Object>> l = t.queryForList(sql);
        System.out.println(l);
    }

}
