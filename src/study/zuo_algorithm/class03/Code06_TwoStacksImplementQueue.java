package study.zuo_algorithm.class03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wnx
 */
public class Code06_TwoStacksImplementQueue {

    public static class TwoStacksToQueue {

        public Deque<Integer> pushStack;
        public Deque<Integer> popStack;

        public TwoStacksToQueue() {
            pushStack = new LinkedList<>();
            popStack = new LinkedList<>();
        }

        public void add(int element) {
            pushStack.push(element);
        }

        public int poll() {
            if(popStack.isEmpty()) {
                pushToPop();
            }

            if(popStack.isEmpty()) {
                throw new RuntimeException("Error");
            }

            return popStack.poll();
        }

        public int peek() {
            if(popStack.isEmpty()) {
                pushToPop();
            }
            if(popStack.isEmpty()) {
                throw new RuntimeException("Error");
            }

            return popStack.peek();
        }

        private void pushToPop() {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.poll());
            }
        }
    }
}
