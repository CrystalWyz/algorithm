package leetcode;

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int resIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                continue;
            }
            nums[resIndex++] = nums[i];
        }
        
        return resIndex;
    }
}