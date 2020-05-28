package extendsandimplement;

/**
 * @author WangYao
 * @date 2019/12/9
 * @function
 */
public class Son extends Father implements Interface1, Interface3 {
    private int a = 4;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    /*
     * 可以继承父类
     * 但是不可以改变返回类型(重写(覆盖),重载,继承,实现)
     */
//    public int f(){return 1;}

    public int f(int i){return i;};

    public void printa(){
        System.out.println(a);
    }

    public static void main(String[] args) {
        /*
         * 接口方法冲突
         * 有超类优先超类否则必须重写
         */

        /*
         * 继承的缺陷
         * 1.易混淆
         * 2.父类构造方法如果调用了父类的方法,而子类重写该方法,创建子类对象会调用子类方法,易出错
         */
//        Father[] f = new Father[5];
//        Son[] s = new Son[5];
//        f = s;
//        f[0] = new Father();

//        new Father();
//        new Son();

        /*
         * 继承里面动态绑定只有方法(虚方法表),如果有同名属性按静态类型,不符合多态
         * (父类有a,子类有a,子类调父类打印a是打印父类a,自己打印a是自己a) 总结,不要同名
         */
//        new Son().printa();
    }
}
