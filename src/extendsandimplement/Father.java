package extendsandimplement;

/**
 * @author WangYao
 * @date 2019/12/9
 * @function
 */
public class Father implements Interface1 {
    private int a = 5;

    public int getA() {
        return a;
    }

    private void setA(int a) {
        this.a = a;
    }

    public void a(Father f){
        System.out.println(f.getA());
    }


    public void f(){}

    public static void f1(int num){
        System.out.println(num);
    }

    public final void f2(){
        System.out.println("father");
    }
}
