package ExtendsAndImplement;

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
    //可以继承父类
    //但是不可以改变返回类型(重写(覆盖),重载,继承,实现)
//    public int f(){return 1;}

    public int f(int i){return i;};

    public static void main(String[] args) {
        /*
         * 接口方法冲突
         */

        /*
         * 继承的缺陷
         */
//        Father[] f = new Father[5];
//        Son[] s = new Son[5];
//        f = s;
//        f[0] = new Father();

        /*
         * 继承里面动态绑定只有方法(虚方法表),如果有同名属性按静态类型,不符合多态
         */
    }
}
