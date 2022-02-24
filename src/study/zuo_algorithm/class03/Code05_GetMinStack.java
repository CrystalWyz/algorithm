package study.zuo_algorithm.class03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wnx
 */
public class Code05_GetMinStack {

        public static class MinStack {
            private final Deque<Integer> dataStack;
            private final Deque<Integer> minStack;

            public MinStack() {
                dataStack = new LinkedList<>();
                minStack = new LinkedList<>();
            }

            public void push(int num) {
                if(this.minStack.isEmpty() || num < this.minStack.peek()) {
                    this.minStack.push(num);
                } else {
                    this.minStack.push(this.minStack.peek());
                }

                this.dataStack.push(num);
            }

            public int pop() {
                if(this.dataStack.isEmpty()) {
                    throw new RuntimeException("Error");
                }

                this.minStack.pop();

                return this.dataStack.pop();
            }

            public int peekMin() {
                if(this.minStack.isEmpty()) {
                    throw new RuntimeException("Error");
                }

                return this.minStack.peek();
            }
        }
}
