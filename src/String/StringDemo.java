package String;

import java.util.StringJoiner;

/**
 * @author WangYao
 * @date 2020/1/5
 * @function
 * @since 1.0
 */
public class StringDemo {

    public static void main(String[] args) {

        /*
         * 构造器
         */
        String s0 = new String();
        String s1 = "a";
        String s2 = new String(s0);

        StringBuilder a = new StringBuilder();//当然也可以使用StringBuffer
        StringJoiner j = new StringJoiner("中间分隔符", "前缀", "后缀");//一种实用工具  可以生成带前后缀且中间有分隔符的字符串

        String s3 = new String(a);
        String s4 = a.toString();//String里面+号实际操作(先生成StringBuilder,append,再toString)

    }

}
