package Collection.ListDemo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author WangYao
 * @date 2019/11/17
 * @function 实现一些链表的方法
 */
public class Implement {

    public Node turnOver(Node head){
        Node pre = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    } //思维

    public Node combine(Node firstHead, Node secondHead){
        if(firstHead == null)
            return secondHead;
        else if(secondHead == null)
            return firstHead;
       Node currFirst = firstHead;
       Node currSecond = secondHead;
       Node preFirst = null;
       Node nextSecond;
       while(currFirst != null && currSecond != null){
           if(currFirst.value > currSecond.value){
               nextSecond = currSecond.next;
               currSecond.next = currFirst;
               if(preFirst != null)
                   preFirst.next = currSecond;
               preFirst = currSecond;
               currSecond = nextSecond;
           }else {
                preFirst = currFirst;
                if(currFirst.next != null) currFirst = currFirst.next;
                else {
                    currFirst.next = currSecond;
                    break;
               }
           }
       }
       if(firstHead.value < secondHead.value) return firstHead;
       else return secondHead;
    } //代码太长

    public Node duplication(Node firstHead, Node secondHead){
        HashSet<Node> h = new HashSet<>();
        for(Node currFirst = firstHead; currFirst != null; currFirst = currFirst.next){
            h.add(currFirst);
        }
        for(Node currSecond = secondHead; currSecond != null; currSecond = currSecond.next){
            if(h.contains(currSecond))
                return currSecond;
        }
        return null;
    }//可以改进 (从n * m 到 n + m,改进完毕)

    public Node reciprocal(Node head, int k){
        int total = 0;
        for(Node curr = head; curr != null; curr = curr.next){
            total++;
        }
        Node curr = head;
        for (int i = 0; i < total - k; i++){
            curr = curr.next;
        }
        return curr;
    }  //可以用空间换时间

    public Node loop(Node head){
        int frequency = 0;
        Node node;
        for(Node curr = head; curr != null; curr = curr.next){
            node = head;
            for(int i = 0; i < frequency; i++){
                if(node == curr)
                    return node;
                node = node.next;
            }
            frequency++;
        }
        return null;
    } //可以改进

    public void printf(Node node){
        for(Node curr = node; curr != null; curr = curr.next){
            System.out.println(curr.value);
        }
    }

}

