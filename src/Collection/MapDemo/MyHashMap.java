package Collection.MapDemo;

import java.util.Map;
import java.util.Set;

/**
 * @author WangYao
 * @date 2020/2/14
 * @function
 */
public class MyHashMap<K, V> {

    Node<K, V>[] table;

    //Set<Map.Entry<K,V>> entrySet;

    static class Node<K, V>{
        final int hash;
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

    public V put(K key, V val){
        Node<K , V> node = new Node<>(key.hashCode(), key, val, null);
        int sat = node.hash % size;

        for(Node<K, V> n = table[sat]; n != null; n = n.next){
            if(n.key.equals(key)){
                return n.setVal(val);
            }
        }

        if(table[sat] != null){
            node.next = table[sat];
        }
        table[sat] = node;
        return null;
    }

    public V get(K key){
        int sat = key.hashCode() % size;
        for(Node<K, V> n = table[sat]; n != null; n = n.next){
            if(n.key.equals(key)){
                return n.getVal();
            }
        }
        return null;
    }

}
