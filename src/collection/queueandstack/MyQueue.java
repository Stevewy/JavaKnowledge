package collection.queueandstack;

import java.util.ArrayList;

/**
 * @author WangYao
 * @date 2019/11/24
 * @function
 */
public class MyQueue<T>{
    private ArrayList<T> arrayList = new ArrayList<>();

    public void push(T t){
        arrayList.add(t);
    }

    public T pop(){
        if(!isEmply())
            return arrayList.remove(0);
        else
            return null;
    }

    public boolean isEmply(){
        return size() == 0;
    }

    public int size(){
        return arrayList.size();
    }
}

/**
 * 数组实现
 * @param <T>
 */
class MyQueue2<T> {
    private Object[] o = new Object[100];
    int tail = 0;
    int head = 0;

    public boolean move(){
        if(head == 0)
            return false;
        for(int i = head; i < 99; i++)
            o[i - head] = o[i];
        tail -= head;
        return true;
    }

    public boolean push(T t){
        if(tail < 99)
            o[tail++] = t;
        else if(move())
            push(t);
        else
            return false;
        return true;
    }

    public T pop(){
        if(head <= tail){
            head++;
            return (T) o[head - 1];
        }
        else
            throw new NullPointerException();
    }

    public int size(){
        return tail - head;
    }
}