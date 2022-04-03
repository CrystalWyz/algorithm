package study.zuo_algorithm.class11;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wnx
 */
public class Code02_SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        preSerial(head, ans);
        return ans;
    }

    public static void preSerial(Node node, Queue<String> queue) {
        if (node == null) {
            queue.offer(null);
        } else {
            queue.offer(String.valueOf(node.value));
            preSerial(node.left, queue);
            preSerial(node.right, queue);
        }
    }

    public static Node preUnserial(Queue<String> preQueue) {
        if (preQueue == null || preQueue.isEmpty()) {
            return null;
        }
        return preBuild(preQueue);
    }

    public static Node preBuild(Queue<String> preQueue) {
        String poll = preQueue.poll();
        if (poll == null) {
            return null;
        }
        Node node = new Node(Integer.parseInt(poll));
        node.left = preBuild(preQueue);
        node.right = preBuild(preQueue);
        return node;
    }

    public static Stack<String> posSerial(Node head) {
        Stack<String> ans = new Stack<>();
        posSerial(head, ans);
        return ans;
    }

    public static void posSerial(Node node, Stack<String> ans) {
        if (node == null) {
            ans.add(null);
        } else {
            posSerial(node.left, ans);
            posSerial(node.right, ans);
            ans.add(String.valueOf(node.value));
        }
    }

    public static Node posUnserial(Stack<String> posStack) {
        if (posStack == null || posStack.isEmpty()) {
            return null;
        }
        return posBuild(posStack);
    }

    public static Node posBuild(Stack<String> posStack) {
        String poll = posStack.pop();
        if (poll == null) {
            return null;
        }
        Node node = new Node(Integer.parseInt(poll));
        node.left = posBuild(posStack);
        node.right = posBuild(posStack);
        return node;
    }

    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<Node> rec = new LinkedList<>();
            rec.offer(head);
            while (!rec.isEmpty()) {
                Node poll = rec.poll();
                if (poll.left != null) {
                    ans.add(String.valueOf(poll.left.value));
                    rec.offer(poll.left);
                } else {
                    ans.add(null);
                }

                if (poll.right != null) {
                    ans.add(String.valueOf(poll.right.value));
                    rec.offer(poll.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public static Node levelUnserial(Queue<String> queue) {
        if (queue == null || queue.isEmpty()) {
            return null;
        }

        Node head = generateNode(queue.poll());
        Queue<Node> rec = new LinkedList<>();
        if (head != null) {
            rec.offer(head);
        }

        while (!rec.isEmpty()) {
            Node poll = rec.poll();
            poll.left = generateNode(queue.poll());
            poll.right = generateNode(queue.poll());
            if (poll.left != null) {
                rec.offer(poll.left);
            }
            if (poll.right != null) {
                rec.offer(poll.right);
            }
        }
        return head;
    }

    private static Node generateNode(String poll) {
        if (poll == null) {
            return null;
        }
        return new Node(Integer.parseInt(poll));
    }
}
