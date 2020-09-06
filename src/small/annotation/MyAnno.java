package small.annotation;

import java.lang.annotation.*;

/**
 * @author WangYao
 * @date 2020/3/3
 * @function 我的注解
 * @version 1.0
 * @since 1.5
 *
 * 本质是接口,继承了 Annotation 但不能这么写上去
 * 可以返回String int enum small.annotation 数组
 *
 * 4个元注解
 * @Target TYPE 类 FIELD 属性 METHOD 方法
 * @Retention SOURCE 不去字节码 CLASS 保留到字节码 RUNTIME 保留到JVM
 * @Documented 保留到doc文档
 * @Inherited 可以被子类继承
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno {

    int first() default 1;//使用时要赋值,default表示默认,可以不赋值

    String value();//只有名字为value而且只有一个,可以省略
}
