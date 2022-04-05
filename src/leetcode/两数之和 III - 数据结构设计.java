package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoSumIII {
    List<Integer> rec;
    boolean sorted;
    public TwoSumIII() {
        rec = new ArrayList<>();
        sorted = false;
    }
    
    public void add(int number) {
        sorted = false;
        rec.add(number);
    }
    
    public boolean find(int value) {

        if (!sorted) {
            Collections.sort(rec);
        }
        int left = 0;
        int right = rec.size() - 1;
        while (left < right) {
            if (rec.get(left) + rec.get(right) > value) {
                right--;
            } else if (rec.get(left) + rec.get(right) < value) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */