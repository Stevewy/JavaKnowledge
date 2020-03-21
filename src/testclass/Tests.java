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
            else if(type == byte.class || type == Byte.class)
                f.set(o, Byte.parseByte(s.get(count++)));
            else if(type == short.class || type == Short.class)
                f.set(o, Short.parseShort(s.get(count++)));
            else if(type == int.class || type == Integer.class)
                f.set(o, Integer.parseInt(s.get(count++)));
            else if(type == double.class || type == Double.class)
                f.set(o, Double.parseDouble(s.get(count++)));
            else if(type == boolean.class || type == Boolean.class)
                f.set(o, Boolean.parseBoolean(s.get(count++)));
        }
        return o;
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("1");
        s.add("2");
        Book2 b = (Book2) parse(Book2.class,s);
        System.out.println(b);
    }

}
