package testclass;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WangYao
 * @date 2020/1/9
 * @function
 */
public class Tests {

    @SneakyThrows
    static Object parse(Class<?> c, List<String> s) {
        Object o = c.newInstance();
        int count = 0;
        Field[] fs = c.getDeclaredFields();
        for(Field f : fs){
            f.setAccessible(true);
            Class type = f.getType();
            if(type == String.class)
                f.set(o, s.get(count++));
            //类推
        }
        return o;
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("1");
        s.add("2");
        Book b = (Book) parse(Book.class,s);
        System.out.println(b);
    }

}
