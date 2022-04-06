package leetcode;

import java.util.ArrayList;
import java.util.List;

// @solution-sync:begin
class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        post(root, res);
        return res;
    }

    private void post(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        post(treeNode.left, res);
        post(treeNode.right, res);
        res.add(treeNode.val);
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