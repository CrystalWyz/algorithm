package study.zuo_algorithm.class03;

/**
 * @author wnx
 */
public class Code04_RingArrayToQueue {

    public static class RingArrayQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public RingArrayQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if(size == limit) {
                throw new RuntimeException("队列已满");
            }
            arr[pushi] = value;
            pushi = (pushi + 1) % limit;
            size++;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("队列已空");
            }
            int res = arr[polli];
            polli = (polli + 1) % limit;
            size--;
            return res;
        }
    }
}
