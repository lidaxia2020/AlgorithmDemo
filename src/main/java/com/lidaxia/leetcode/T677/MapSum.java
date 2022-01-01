package com.lidaxia.leetcode.T677;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/1 16:55
 */
class MapSum {

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            Character c = key.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
        }

        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }

        return sum(cur);
    }


    private int sum(Node node) {
        int result = node.value;

        for (Character c : node.next.keySet()) {
            result += sum(node.next.get(c));
        }
        return result;
    }

    /**
     * 删除操作
     *
     * @param word
     */
    public void remove(String word) {
        Node cur = root;
        Node remove = root;
        char result = 0;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return;
            } else if (cur.next.get(c).next.size() > 1 || cur.isWord) {
                remove = cur;
                result = c;
            }
            cur = cur.next.get(c);
        }

        if (cur.isWord) {
            if (remove.next.get(remove) == null || remove.next.get(remove).next.size() != 0) {
                cur.value = 0;
            } else {
                remove.next.remove(result);
            }
        }

    }

    private class Node {
        public boolean isWord;
        public int value;
        public HashMap<Character, Node> next;

        public Node() {
            next = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("appl", 2);
        System.out.println(mapSum.sum("ap"));
        mapSum.remove("ap");
        System.out.println(mapSum.sum("ap"));
        mapSum.remove("appl");
        System.out.println(mapSum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */