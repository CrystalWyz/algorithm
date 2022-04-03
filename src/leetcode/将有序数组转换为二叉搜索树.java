package leetcode;

// @solution-sync:begin
class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return searchTree(nums, 0, nums.length);
    }

    public TreeNode searchTree(int[] nums, int start, int end){
        if(start == end){
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = searchTree(nums, start, mid);
        root.right = searchTree(nums, mid + 1, end);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}