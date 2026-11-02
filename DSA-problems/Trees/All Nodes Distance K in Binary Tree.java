// PS: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> mp = new HashMap<>();
        prepareMap(root,mp);
        //System.out.println(mp);
        List<Integer> ans = new ArrayList<>();
       
        Set<TreeNode> vis = new HashSet<>();
        vis.add(target);
        dfs(target,mp,ans,vis,k);
        return ans;
    }
    public static void dfs(TreeNode root, Map<TreeNode,TreeNode> mp, List<Integer> ans,Set<TreeNode> vis, int k){
        if(root == null) return;
        if(k == 0) {
            ans.add(root.val);
            return;
        }
        if(!vis.contains(root.left)) {
            vis.add(root.left);
            dfs(root.left,mp,ans,vis,k - 1);
        }
        if(!vis.contains(root.right)){
            vis.add(root.right);
            dfs(root.right,mp,ans,vis,k - 1);
        }
        if(!vis.contains(mp.get(root))){
            vis.add(mp.get(root));
            dfs(mp.get(root),mp,ans,vis,k - 1);
        }
        
    }
    public static void prepareMap(TreeNode root,Map<TreeNode,TreeNode> mp){
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        if(!mp.containsKey(root.left)){
            mp.put(root.left,root);
        }
        if(!mp.containsKey(root.right)){
            mp.put(root.right,root);
        }
        prepareMap(root.left,mp);
        prepareMap(root.right,mp);
    }

    
}