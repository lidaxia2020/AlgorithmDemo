package com.lidaxia.trie;

import java.util.HashMap;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/30 20:39
 */
public class Trie {

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        /**
         * 之前无该单词
         */
        if (!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }


    public int getSize() {
        return size;
    }


    private class Node {
        public boolean isWord;

        public HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }

    }

}
