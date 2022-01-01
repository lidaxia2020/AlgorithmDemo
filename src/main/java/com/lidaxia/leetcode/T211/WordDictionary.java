package com.lidaxia.leetcode.T211;

import java.util.HashMap;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/1 16:25
 */
class WordDictionary {

    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length())
            return node.isWord;

        Character c = word.charAt(index);
        if ('.' == c) {
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index+1))
                    return true;
            }
            return false;
        } else {
            if (node.next.get(c) == null)
                return false;
            else
                return match(node.next.get(c), word, index+1);
        }
    }


    private class Node {

        public boolean isWord;
        public HashMap<Character, Node> next;

        public Node() {
            this.next = new HashMap<>();
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */