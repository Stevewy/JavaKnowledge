package collection.listdemo;

/**
 * @author WangYao
 * @date 2019/11/17
 * @function
 */
public class Node {
    int value;
    Node next = null;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {

    }

    /**
     * 下面为测试建造者模式(使用嵌套类)
     * @param builder
     */

    public Node(Builder builder){
        value = builder.value;
        next = builder.next;
    }

    public static class Builder{
        final int value;
        Node next = null;
        Node tail = null;

        public Builder(int value){
            this.value = value;
        }

        public Builder nextvalue(int value){
            if(next == null) {
                next = new Node(value);
                tail = next;
            }
            tail.next = new Node(value);
            tail = tail.next;
            return this;
        }

        public Node getNode(){
            return new Node(this);
        }
    }
}
