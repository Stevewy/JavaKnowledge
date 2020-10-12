package collection.listdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author WangYao
 * @date 2020/10/12
 * @function 记录一些链表操作注意事项
 */
public class Test {

    public static void main(String[] args) {
        /**
         * list在删除时需要使用迭代器来删除而不能使用foreach来删除
         * 原因: foreach本质是调用迭代器来遍历,而如果使用list.remove会改变modCount(修改次数)的值,与使用的迭代器里面的exceptedModCount不相同
         * 但是删除倒数第二个不会报错,原因在于删除倒数第二个,最后只剩下一个,没有调用.next()方法
         */
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");

//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            String s = iterator.next();
//            if(s.equals("1")){
//                iterator.remove();
//            }
//        }

//        for (String s: list) {
//            if("1".equals(s)){
//                list.remove(s);
//            }
//        }
//
//        for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
    }
}
