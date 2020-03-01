package myclass;

import java.lang.reflect.*;

/**
 * @author WangYao
 * @date 2019/12/15
 * @see Field
 * @see Constructor
 * @see Method
 * @see Modifier
 * @function 打印一个类的所有属性方法和构造器
 * 使用reflect里面Field Constructor Method  其中用Modifier查看访问权限以及几个关键字
 */
public class ClassDemo {

    private static void printModeifer(String modifier, String name, Class[] cls){//打印类型
        if(modifier.length() > 0)
            System.out.print("   " + modifier + " " + name + "(");
        else
            System.out.print("   " + name + "(");
        for(int i = 0; i < cls.length; i++){
            if(i != 0)
                System.out.print(", ");
            System.out.print(cls[i].getName());
        }
        System.out.println(");");
    }

    private static void printConstructors(Class c){//打印构造器
        Constructor[] constructors = c.getDeclaredConstructors(); //没有Declared是只给public方法
        for(Constructor con : constructors){
            String name = con.getName();
            String modifier = Modifier.toString(con.getModifiers());//StringJoiner
            Class[] cls = con.getParameterTypes();
            printModeifer(modifier, name, cls);
        }
    }

    private static void printMethods(Class c){//打印方法
        Method[] methods = c.getDeclaredMethods();
        for(Method method: methods){
            Class retType = method.getReturnType();
            String name = retType.getName() + " " + method.getName();
            String modifier = Modifier.toString(method.getModifiers());
            Class[] cls = method.getParameterTypes();
            printModeifer(modifier, name, cls);
        }
    }

    private static void printField(Class c){//打印域(属性)
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields){
            Class retType = field.getType();
            String name = retType.getName() + " " + field.getName();
            String modifer = Modifier.toString(field.getModifiers());
            Class[] cls = new Class[0];
            printModeifer(modifer, name, cls);
        }
    }

    public static void main(String[] args) throws Throwable {
        /*
        利用反射来得到一个类全部域 构造器 方法
         */
        /*Scanner in = new Scanner(System.in);
        string name = in.nextLine();
        try {
            myclass c = myclass.forName(name);
            myclass sc = c.getSuperclass();                                               //得到父类
            string modifiers = Modifier.toString(c.getModifiers());                     //得到类型(PUBLIC... STATIC FINAL SYNCHRONIZED VOLATILE TRANSIENT NATIVE INTERFACE ABSTRACT STRICT BRIDGE VARARGS SYNTHETIC ANNOTATION ENUM MANDATED)
            if(modifiers.length() > 0)
                System.out.println("modifiers = " + modifiers);
            if(sc != null && !sc.getName().equals("java.lang.Object"))               //sc!=Object.class;
                System.out.println("extends " + sc.getName());
            System.out.println("{");
            printField(c);
            System.out.println();
            printConstructors(c);
            System.out.println();
            printMethods(c);
            System.out.println("}");
        }
        catch (exception e){
//            System.out.println("出问题");
            Logger.getGlobal().log(Level.WARNING, "出问题", e);//新打印方法
        }*/

        /*
         * 利用反射来得到并输出一个类所有属性(域)  (也可以改变)
         */
//        book book = new book("ad","a");
//        System.out.println(ObjectAnalyzer.toString(book));
//        myclass c = book.getClass();
//        Field f = c.getDeclaredField("name");//改变叫做name的域
//        f.setAccessible(true);//这个不加的话就有限制(如果可以直接改就可以不加,否则就要加)
//        f.set(book, "你好");//第一个是对象,第二个是你要改的值
//        System.out.println(f.get(book));

        /*
         * 利用反射来写泛型代码(调用其构造器)  (class那个只能调用无参构造器, 如果没有无参(或者权限不够)则报错)
         */
//        book[] b = new book[5];
//        b[0] = new book("1","1");
//        System.out.println(b[0]);
//        book[] b1 = (book[]) copeOf(b, 7); //这个使用System里面的copy,用于数组
//        System.out.println(b1.length);
//        book b3 = book.class.newInstance();  //过时了    不在一个包必须要public 一个包除了private都可以

//        book x = new book();
//        book b4 = book.class.cast(x);  //新方法,用这个对象来构造,里面可以不是Book类型的对象,可以是其子类 效果等同与 book b4 = (book) x;

        /*
         * 利用反射来调用一个类的方法(代理)
         */
//        Method m = ClassDemo.class.getDeclaredMethod("x", string.class, Integer.class);
//        m.invoke(null, "s", 1);//第一个是对象,如果是静态可以写null,后面是参数 使用...

    }

    private static void x(String s, Integer i){
        System.out.println(i + "  私有  " + s);
    }

    public static Object copeOf(Object obj, int newLength){
        Class c = obj.getClass();
        if(!c.isArray()) return null; //非数组,返回null
        Object o = Array.newInstance(c.getComponentType(), newLength);
        System.arraycopy(obj, 0, o, 0, Math.min(newLength, Array.getLength(obj)));
        return o;
    }
}
