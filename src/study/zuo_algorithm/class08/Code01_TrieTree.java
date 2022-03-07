package study.zuo_algorithm.class08;

import org.w3c.dom.Node;

public class Code01_TrieTree {

    public static class Node {
        public int pass;
        public int end;
        public Node[] children;

        public Node() {
            pass = 0;
            end = 0;

            children = new Node[26];
        }
    }

    public static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node p = root;
            for (char c : chars) {
                int path = c - 'a';
                if(p.children[path] == null) {
                    return 0;
                }
                p = p.children[path];
            }
            return p.end;
        }

        public void insert(String word) {
            if(word == null) {
                return;
            }

            char[] chars = word.toCharArray();
            Node p = root;
            p.pass++;
            for (char c : chars) {
                int path = c - 'a';
                if (p.children[path] == null) {
                    p.children[path] = new Node();
                }
                p = p.children[path];
                p.pass++;
            }
            p.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node p = root;
                for (char c : chars) {
                    int path = c - 'a';
                    if (--p.children[path].pass == 0) {
                        p.children[path] = null;
                        return;
                    }
                    p = p.children[path];
                }
                p.end--;
            }
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            Node p = root;
            char[] chars = pre.toCharArray();
            for (char c : chars) {
                int path = c - 'a';
                if (p.children[path] == null) {
                    return 0;
                }
                p = p.children[path];
            }
            return p.pass;
        }


    }
}
