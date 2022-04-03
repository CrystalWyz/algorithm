package study.zuo_algorithm.class11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author wnx
 */
public class Code04_TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        Map<Node, Integer> levelMap = new HashMap<>();
        int level = 1;
        int curLevelNodes = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int curNodeLevel = levelMap.get(poll);
            if (poll.left != null) {
                levelMap.put(poll.left, curNodeLevel + 1);
                queue.offer(poll);
            }
            if (poll.right != null) {
                levelMap.put(poll.right, curNodeLevel + 1);
                queue.offer(poll);
            }

            if (curNodeLevel == level) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                level++;
                curLevelNodes = 0;
            }
        }

        max = Math.max(max, curLevelNodes);

        return max;
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }

        Queue<Node> cur = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();
        cur.offer(head);
        int max = 0;
        while (!cur.isEmpty()) {
            max = Math.max(max, cur.size());
            while (!cur.isEmpty()) {
                Node poll = cur.poll();
                if (poll.left != null) {
                    next.offer(poll.left);
                }
                if (poll.right != null) {
                    next.offer(poll.right);
                }
            }

            if (!next.isEmpty()) {
                cur = next;
                next = new LinkedList<>();
            } else {
                break;
            }
        }

        return max;
    }
}
