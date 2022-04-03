package study.zuo_algorithm.class13;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wnx
 */
public class Code03_lowestAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node lowestAncestor1(Node head, Node o1, Node o2) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);

        Set<Node> o1Set = new HashSet<>();
        o1Set.add(o1);
        Node cur = o1;
        while (parentMap.get(o1) != null) {
            o1Set.add(parentMap.get(cur));
            cur = parentMap.get(cur);
        }

        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }

        return cur;
    }

    private static void fillParentMap(Node head, Map<Node, Node> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }

    public static Node lowestAncestor2(Node head, Node o1, Node o2) {
        if (head == null) {
            return null;
        }
        return process(head, o1, o2).ans;
    }

    private static Info process(Node node, Node o1, Node o2) {
        if (node == null) {
            return new Info(false, false, null);
        }

        Info left = process(node.left, o1, o2);
        Info right = process(node.right, o1, o2);
        boolean findA = (node == o1) || left.findA || right.findA;
        boolean findB = (node == o2) || left.findB || right.findB;
        Node ans = null;
        if (left.ans != null) {
            ans = left.ans;
        } else if (right.ans != null) {
            ans = right.ans;
        } else {
            if (findA && findB) {
                ans = node;
            }
        }
        return new Info(findA, findB, ans);
    }

    private static class Info {
        boolean findA;
        boolean findB;
        Node ans;

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }
}
