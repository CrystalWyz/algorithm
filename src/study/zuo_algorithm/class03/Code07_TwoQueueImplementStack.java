package study.zuo_algorithm.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wnx
 */
public class Code07_TwoQueueImplementStack {

    public static class TwoQueueToStack<T> {

        private Queue<T> queue;
        private Queue<T> help;

        public TwoQueueToStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T e) {
            queue.offer(e);
        }

        public T poll() {
            if(queue.isEmpty()) {
                throw new RuntimeException("Error");
            }

            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            T e = queue.poll();
            Queue<T> temp = queue;
            queue = help;
            help = temp;

            return e;
        }

        public T peek() {
            if(queue.isEmpty()) {
                throw new RuntimeException("Error");
            }

            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            T e = queue.poll();
            help.offer(e);

            Queue<T> temp = queue;
            queue = help;
            help = temp;

            return e;
        }
    }
}
