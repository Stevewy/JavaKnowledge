package collection.mapdemo;

/**
 * @author WangYao
 * @date 2020/2/14
 * @function 模拟hashmap
 */
public class MyHashMap<K, V> {

    Node<K, V>[] table;

    //Set<Map.Entry<K,V>> entrySet;

    static class Node<K, V>{
        final int hash; //先调用hashcode方法获取key的hashcode值,右移16位和原来16位做异或,在和table.length-1进行与运算,所以table.length要为2的整数次幂
        final K key;
        V val;
        Node<K, V> next;

        Node(int hash, K key, V val, Node<K, V> next){
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public final K getKey(){return key;}
        public final V getVal(){return val;}
        public final String toString(){return key + "=" + val;}

        public final V setVal(V newVal){
            V oldVal = val;
            val = newVal;
            return oldVal;
        }
    }

    int size = 16;

    final float loadFactor;

    public MyHashMap(int size, float loadFactor){
        if (size < 0)
            throw new IllegalArgumentException("Illegal size: " + size);
        if (size > (1 << 30))
            size = (1 << 30);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        this.size = size;
    }

    public MyHashMap(int size){
        this(size, 0.75f);
    }

    public MyHashMap(){
        loadFactor = 0.75f;
    }

    //hash值目前不太行
    private int hash(K key){
        return key.hashCode() % size;
    }

    public V put(K key, V val){
        Node<K , V> node = new Node<>(hash(key), key, val, null);
        int sat = node.hash;//存起来只算一遍,这里直接调

        for(Node<K, V> n = table[sat]; n != null; n = n.next)  //找一下有没有
            if(n.key.equals(key))
                return n.setVal(val);


        node.next = table[sat];//头部更新,java7做法,只用数字与链表
        table[sat] = node;
        return null;
    }

    public V get(K key){
        int sat = hash(key);
        for(Node<K, V> n = table[sat]; n != null; n = n.next)
            if(n.key.equals(key))
                return n.getVal();

        return null;
    }

}
