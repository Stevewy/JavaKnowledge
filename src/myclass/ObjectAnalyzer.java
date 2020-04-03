package myclass;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author WangYao
 * @date 2019/12/16
 * @function 工具类,作用打印一个类
 */
public class ObjectAnalyzer {

    private static ArrayList<Object> a = new ArrayList<>();

    public static String toString(Object obj){
        if(obj == null) return "null";
        if(a.contains(obj)) return "...";

        StringBuilder r;
        a.add(obj);
        Class c = obj.getClass();
        if(c == String.class) return (String) obj;
        if(c.isArray()){
            r = new StringBuilder(c.getComponentType().toString()).append("[]{") ;
            for(int i = 0; i < Array.getLength(obj); i++){
                if(i > 0) r.append(',');
                Object o = Array.get(obj, i);
                r.append(o);
            }
            return r.append('}').toString();
        }

        r = new StringBuilder(c.getName());
        do {
            r.append('[');
            Field[] fs = c.getDeclaredFields();
            AccessibleObject.setAccessible(fs, true);
            for(Field f : fs){
                if(!Modifier.isStatic(f.getModifiers())){
                    if(!r.toString().endsWith("[")) r.append(',');
                    r.append(f.getName()).append('=');
                    try {
                        Class cl = f.getType();
                        Object val = f.get(obj);
                        r.append(val);
                    }
                    catch (IllegalAccessException e){
                        Logger.getGlobal().log(Level.WARNING, "错误", e);
                    }
                }
            }
            r.append(']');
            c = c.getSuperclass();
        }while (c != null);
        return r.toString();
    }

}
