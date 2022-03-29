package leetcode;

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int resIndex = 1;
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastNum){
                continue;
            }
            nums[resIndex++] = nums[i];
            lastNum = nums[i];
        }
        return  resIndex;
    }
}