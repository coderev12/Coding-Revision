https://leetcode.com/problems/diameter-of-binary-tree/description/
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
    public int diameterOfBinaryTree(TreeNode root) {
        // Diameter = height(left) + height(right)
        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }
    public static int height(TreeNode root,int[] diameter){
        if(root == null) return 0;

        int left = height(root.left,diameter);
        int right = height(root.right,diameter);

        diameter[0] = Math.max(diameter[0],left + right);
        return 1 + Math.max(left, right);
    }
}