package leetcode;

class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            
            res = Math.max(res, sum);
        }
        return res;
    }
}