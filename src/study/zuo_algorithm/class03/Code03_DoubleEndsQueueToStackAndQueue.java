package study.zuo_algorithm.class03;

import org.w3c.dom.Node;

import java.util.Queue;

/**
 * @author wnx
 */
public class Code03_DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        public T value;
        public Node<T> pre;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void leftAdd(T value) {
            Node<T> cur = new Node<>(value);

            if(head == null) {
                head = cur;
                tail = cur;
            } else {
                head.pre = cur;
                cur.next = head;
                head = cur;
            }
        }

        public void rightAdd(T value) {
            Node<T> cur = new Node<>(value);

            if(head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.pre = tail;
                tail = cur;
            }
        }

        public T leftPop() {
            if(head == null) {
                return null;
            }

            Node<T> cur = this.head;
            if(head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
                cur.next = null;
            }
            return cur.value;
        }

        public T rightPop() {
            if(tail == null) {
                return null;
            }

            Node<T> cur = this.tail;
            if(head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
                cur.pre = null;
            }
            return cur.value;
        }
    }

    public static class Stack<T> {
        private DoubleEndsQueue<T> queue;

        public Stack() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.rightAdd(value);
        }

        public T pop() {
            return queue.rightPop();
        }
    }

    public static class Queue<T> {
        private DoubleEndsQueue<T> queue;

        public Queue() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.leftAdd(value);
        }

        public T pop() {
            return queue.rightPop();
        }
    }
}
