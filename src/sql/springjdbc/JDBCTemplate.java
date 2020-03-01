package sql.springjdbc;

import sql.Book;
import sql.datasourse.Druid;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/3/1
 * @function
 */
public class JDBCTemplate {

    public static void main(String[] args) {
        JdbcTemplate t = new JdbcTemplate(Druid.getDataSource());
        String sql = "select * from book;";
        /*List<book> l = t.query(sql, new RowMapper<book>() {
            @Override
            public book mapRow(ResultSet rs, int i) throws SQLException {
                return new book(rs.getInt("id"),rs.getString("bname"),rs.getString("author"),rs.getDouble("price"),rs.getDate("publishDate"),rs.getInt("number"));
            }
        });*/
        List<Book> l = t.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        System.out.println(l);
    }

}
