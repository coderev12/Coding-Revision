// PS: https://leetcode.com/problems/count-complete-tree-nodes/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if(leftHeight == rightHeight) return (int) Math.pow(2,leftHeight) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static int leftHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + leftHeight(root.left);
    }
    public static int rightHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + rightHeight(root.right);
    }
}