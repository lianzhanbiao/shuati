package zj;

import java.util.*;

class Node {
    public int key;
    public int value;
    public Node pre;
    public Node next;
    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}

class DoubleList {
    public Node head;
    public Node tail;
    public DoubleList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    public void remove(Node node) {
        System.out.println("要删除的节点："+node.key);
        System.out.println("node pre="+node.pre.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public void addFirst(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    public Node removeLast() {
        Node last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        return last;
    }
}

class LRUCache {
    public int capacity;
    public int size;
    public Map<Integer, Node> map;
    public DoubleList dlist;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.dlist = new DoubleList();
    }

    public int get(int key) {
        System.out.println(map.size());
        if (map.containsKey(key)) {
            // make first
            Node node = map.get(key);
            System.out.println(node.value);
            dlist.remove(node);
            System.out.println("删除后：");
            print();
            dlist.addFirst(node);
            System.out.println("移动后：");
            print();
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (size >= capacity) {
            Node last = dlist.removeLast();
            int k = last.key;
            map.remove(k);
        }
        map.put(key, node);
        size++;
        dlist.addFirst(node);
    }
    public void print() {
        Node cur = dlist.head.next;
        while(cur != dlist.tail) {
            System.out.print("("+cur.key+","+cur.value+")");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.print();
        System.out.println(cache.get(2));
        cache.print();
    }
}