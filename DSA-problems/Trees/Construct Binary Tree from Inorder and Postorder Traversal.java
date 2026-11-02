PS: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
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
    public static int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        index = n - 1;
        return buildTree(postorder,inorder,0,n-1);
    }
    public static TreeNode buildTree(int[] postorder, int[] inorder, int start, int end){
        if(start > end || index < 0) return null;
        TreeNode root = new TreeNode(postorder[index--]);
        int leftIndex =  searchIndex(inorder,root.val);
        root.right = buildTree(postorder,inorder,leftIndex+1,end);
        root.left =  buildTree(postorder,inorder,start, leftIndex-1);
        return root;
    }
    public static int searchIndex(int[] array, int target){
        int n = array.length;
        for(int i = 0;i < n;i++){
            if(array[i] == target) return i;
        }
        return -1;
    }
}