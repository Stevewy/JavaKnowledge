package Annotation;

import java.io.Console;
import java.lang.annotation.Annotation;

/**
 * @author WangYao
 * @date 2019/12/14
 * @function
 */
public class Text1 {

    public static void a(int x){
        System.out.println(x);
    }


    public static void main(String[] args) {
        /*String pkgName = "TextClass";
        Package pkg = Package.getPackage(pkgName);
        //获得包上的注解
        Annotation[] annotations = pkg.getAnnotations();
        //遍历注解数组
        for (Annotation an : annotations) {
            if (an instanceof Text) {
                System.out.println("Hi,I'm the PkgAnnotation");
            }
        }*/
    }
    public void text() {
        System.out.print("请输入密码:");
        Console con = System.console();
        String pswd = new String(con.readPassword());//因为读取的是字符数组,所以需要用new String()来把字符数组转成字符串
        System.out.println("你刚刚输入的密码是" + pswd);
    }
}
