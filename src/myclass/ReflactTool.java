package myclass;

import annotation.ReflactAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author WangYao
 * @date 2020/3/3
 * @function 通过类名和方法名来调用方法(目前缺陷较大)
 */
@Deprecated
@ReflactAnnotation(className = "testclass.Tests",method = "Test1")
public class ReflactTool {

    public static void main(String[] args) {
        //得到该类的类
        Class<ReflactTool> r = ReflactTool.class;
        //得到注解对象(实际是子类方法)
        ReflactAnnotation annotation = r.getAnnotation(ReflactAnnotation.class);
        //得到注解里面的类名和方法名
        String className = annotation.className();
        String methodName = annotation.method();

        try {
            Class cls = Class.forName(className);
            Object obj = cls.newInstance();
            Method method = cls.getMethod(methodName);
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            System.out.println("没找到该类");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("没该方法");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
