package leetcode.p146;

import java.util.HashMap;

class Node {
    public int key, val;
    public Node next, pre;
    public Node (int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    public Node head, tail;
    public int size;
    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addLast(Node node) {
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
        size += 1;
    }

    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size -= 1;
    }

    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
}

public class LRUCache {

    public HashMap<Integer, Node> map;
    public DoubleList cache;
    public int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        cap = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        makeRecent(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (cache.size >= cap) {
            Node first = cache.removeFirst();
            map.remove(first.key);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        cache.addLast(node);
    }

    public void makeRecent (Node node) {
        cache.remove(node);
        cache.addLast(node);
    }

}
