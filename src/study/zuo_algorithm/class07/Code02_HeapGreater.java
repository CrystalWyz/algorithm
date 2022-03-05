package study.zuo_algorithm.class07;

import java.util.*;

/**
 * @author wnx
 */
public class Code02_HeapGreater<T> {
    
    private final List<T> data;
    private final Map<T, Integer> rec;
    private int heapSize;
    private final Comparator<? super T> comparator;

    public Code02_HeapGreater(Comparator<? super T> comparator) {
        data = new ArrayList<>();
        rec = new HashMap<>();
        heapSize = 0;
        this.comparator = comparator;
    }
    
    public boolean isEmpty() {
        return heapSize == 0;
    }
    
    public int size() {
        return  heapSize;
    }
    
    public boolean contains(T element) {
        return rec.containsKey(element);
    }
    
    public T peek() {
        return data.get(0);
    }
    
    public void push(T element) {
        data.add(element);
        rec.put(element, heapSize);
        heapInsert(heapSize++);
    }

    private void heapInsert(int index) {
        while (comparator.compare(data.get(index), data.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int i1, int i2) {
        T o1 = data.get(i1);
        T o2 = data.get(i2);
        data.set(i1, o2);
        data.set(i2, o1);
        rec.put(o1, i2);
        rec.put(o2, i1);
    }
    
    private T pop() {
        T ans = data.get(0);
        swap(0, heapSize - 1);
        heapify(0);
        rec.remove(ans);
        data.remove(heapSize--);
        return ans;
    }

    public void remove(T obj) {
        Integer index = rec.get(obj);
        T replace = data.get(heapSize - 1);
        rec.remove(obj);
        data.remove(heapSize--);
        if(!obj.equals(replace)) {
            data.set(index, replace);
            rec.put(replace, index);
            resign(replace);
        }
    }

    private void resign(T replace) {
        heapify(rec.get(replace));
        heapInsert(rec.get(replace));
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 把较大孩子的下标，给largest
            int largestIndex = left + 1 < heapSize && comparator.compare(data.get(left + 1), data.get(left)) < 0 ? left + 1 : left;
            largestIndex = comparator.compare(data.get(largestIndex), data.get(index)) > 0 ? largestIndex : index;
            if (largestIndex == index) {
                break;
            }
            // index和较大孩子，要互换
            swap(largestIndex, index);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }
}
