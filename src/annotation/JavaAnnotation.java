package annotation;

/**
 * @author WangYao
 * @date 2020/3/3
 * @function
 */
public class JavaAnnotation {

    @Override//重写
    public String toString(){
        return super.toString();
    }

    @Deprecated//过时
    public void first(){
        System.out.println("1");
    }

    @SuppressWarnings("all")//压制警告
    public void secound(){
        System.out.println("2");
    }

}
