package leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> rec = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!rec.containsKey(target - nums[i])) {
                rec.put(nums[i], i);
            } else {
                return new int[]{i, rec.get(target - nums[i])};
            }
        }
        return null;
    }
}