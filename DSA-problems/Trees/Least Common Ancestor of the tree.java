// PS: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // ArrayList<Integer> path1 = new ArrayList<>();
        // ArrayList<Integer> path2 = new ArrayList<>();
        // lowestCommonAncestor(root,p,path1);
        // lowestCommonAncestor(root,q,path2);
        if(root == null) return root;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }
    // public static boolean lowestCommonAncestor(TreeNode root, TreeNode target, ArrayList<Integer> path){
    //     if(root == null) return false;     
    //     path.add(root.val);
    //     if(root == target) return true;

    //     if(lowestCommonAncestor(root.left, target, path) || lowestCommonAncestor(root.right,target, path)) return true;
    //     path.remove(path.size() - 1);
    //     return false;
    // }
}