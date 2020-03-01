package collection.queueandstack;

import java.util.ArrayList;

/**
 * @author WangYao
 * @date 2019/11/24
 * @function
 */
public class MyStack<T> {
    private ArrayList<T> arrayList = new ArrayList<>();

    public void push(T t){
        arrayList.add(t);
    }

    public T pop(){
        return arrayList.remove(arrayList.size() - 1);
    }

    public int size(){
        return arrayList.size();
    }
}

/**
 * 数组实现
 * @param <T>
 */
class MyStack2<T> {
    private Object[] o = new Object[100];
    int tail = 0;

    public boolean push(T t){
        if(tail == 100)
            return false;
        o[tail++] = t;
        return true;
    }

    public T pop(){
        if(tail > 0){
            tail--;
            return (T) o[tail];
        }
        else
            throw new NullPointerException();
    }

    public int size(){
        return tail;
    }
}