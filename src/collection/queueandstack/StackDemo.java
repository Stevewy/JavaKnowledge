package collection.queueandstack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author WangYao
 * @date 2019/11/24
 * @function
 */
public class StackDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }
            for(int i = 0; i < n; i++){
                b[i] = in.nextInt();
            }
            System.out.println(o(a, b));
        }

    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {  //传空指针我会出问题
        Stack<Integer> s = new Stack();
        int j = 1;
        s.push(pushA[0]);
        for(int i = 0; i < popA.length; i++){
            if(popA[i] == s.peek()){
                s.pop();
                break;
            }
            else if(j == pushA.length)
                return false;
            s.push(pushA[j]);
            i--;
            j++;
        }
        return true;
    }

    public static boolean o(int [] pushA,int [] popA){
        Stack<Integer> s = new Stack<>();
        int in = 0;
        for(int i : pushA){
            s.push(i);
            while (s.peek() == popA[in]){
                s.pop();
                in++;
                if(s.empty())
                    break;
            }
        }
        return s.empty();
    }

    public static boolean ok(int a[], int b[]){             //使用自己方法
        int x = 0;
        for(int j = 0; j < a.length; j++){
            if(b[0] == a[j]){
                a[j] = 0;
                x = j;
                break;
            }
        }
        for(int i = 1; i < b.length; i++){
            for(int j = 0; j < a.length; j++){
                if(b[i] == a[j]){
                    for(int k = j + 1; k < x; k++){
                        if(a[k] != 0)
                            return false;
                    }
                    a[j] = 0;
                    x = j;
                    break;
                }
            }
        }
        return true;
    }
}
