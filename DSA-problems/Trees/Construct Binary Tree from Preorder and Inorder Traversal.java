// PS: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        int n = preorder.length;
        return buildTree(preorder,inorder,0,n-1);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        int leftIndex =  searchIndex(inorder,root.val);
        root.left =  buildTree(preorder,inorder,start, leftIndex-1);
        root.right = buildTree(preorder,inorder,leftIndex+1,end);
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