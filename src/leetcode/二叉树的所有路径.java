package leetcode;

import java.util.LinkedList;
import java.util.List;



// @solution-sync:begin
class Path {
    public static  void path(TreeNode root,String path,LinkedList<String> paths)
    {
        if (root!=null)
        {
            path+=Integer.toString(root.val);
            if ((root.left==null)&&(root.right==null))
            {
                paths.add(path);
            }else 
            {
                path+="->";
                path(root.right,path,paths);
                path(root.left,path,paths);
            }
        }
    }
    public List<String> binaryTreePaths(TreeNode root)
    {
        LinkedList<String> paths=new LinkedList<>();
        path(root,"",paths);
        return paths;
    }

    private static class TreeNode {
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