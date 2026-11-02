PS:https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int value){
            this.node = node;
            this.idx = value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        int first = 0;
        int last = 0;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        while(!queue.isEmpty()){
            int size = queue.size();;
            for(int i = 0;i<size;i++){
                Pair curr = queue.poll();
                min = Math.min(min,curr.idx);
                if(i == 0) {
                    first = curr.idx;
                }
                if(i == size - 1){
                    last = curr.idx;
                }
                if(curr.node.left != null) queue.offer(new Pair(curr.node.left,2 * (curr.idx - min) + 1));
                if(curr.node.right != null) queue.offer(new Pair(curr.node.right, 2 * (curr.idx - min) + 2));
            }
            ans = Math.max(ans, last - first + 1);
            
        }  
        
        return ans;
    }
}