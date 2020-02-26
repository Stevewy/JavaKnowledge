package Collection.QueueAndStack;

/**
 * @author WangYao
 * @date 2019/11/24
 * @function 栈和队列的互相转换
 */
public class Solution {
    MyStack<Integer> myStack1 = new MyStack<>();
    MyStack<Integer> myStack2 = new MyStack<>();
    MyQueue<Integer> myQueue1 = new MyQueue<>();
    MyQueue<Integer> myQueue2 = new MyQueue<>();

    /**
     * Queue实现Stack
     * @param args
     */
//    public void push(Integer in){
//        myQueue1.push(in);
//        if(myQueue1.size() != 1){
//            while(myQueue1.size() != 1){
//                myQueue2.push(myQueue1.pop());
//            }
//            while (!myQueue2.isEmply()){
//                myQueue1.push(myQueue2.pop());
//            }
//        }
//    }
//
//    public int pop(){
//        return myQueue1.pop();
//    }

    /**
     * MyStack 实现 MyQueue
     * @param args
     */
//    public void push(Integer in){
//        int x = myStack2.size();
//        for(int i = 1; i <= x; i++){
//            myStack1.push(myStack2.pop());
//        }
//        myStack1.push(in);
//    }

//    public int pop(){
//        int x = myStack1.size();
//        for(int i = 1; i <= x; i++){
//            myStack2.push(myStack1.pop());
//        }
//        return myStack2.pop();
//    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.push(1);
//        solution.push(2);
//        solution.push(3);
//        System.out.println(solution.pop());
    }
}
