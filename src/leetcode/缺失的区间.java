package leetcode;

import java.util.List;
import java.util.ArrayList;

// @solution-sync:begin
class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(lower > upper) {
            return res;
        }
        for (int num : nums) {
            if (lower - num == 0) {
                lower++;
            } else if (num - lower == 1) {
                res.add(String.valueOf(lower));
                lower = num + 1;
            } else {
                res.add(lower + "->" + (num - 1));
                lower = num + 1;
            }
        }
        if (lower - upper == 0) {
            res.add(String.valueOf(lower));
        } else if(upper - lower >= 1) {
            res.add(lower + "->" + upper);
        }
        return res;
    }
}