// PS:https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
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

    class Pair {
        int row, val;
        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int h = height(root) - 1;
        int n = 2 * h + 1;

        List<List<Pair>> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cols.add(new ArrayList<>());
        }

        dfs(root, cols, 0, 0, h);

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Pair> col : cols) {
            if (col.isEmpty()) continue;

            col.sort((a, b) -> {
                if (a.row == b.row)
                    return a.val - b.val;
                return a.row - b.row;
            });

            List<Integer> list = new ArrayList<>();
            for (Pair p : col) {
                list.add(p.val);
            }
            ans.add(list);
        }

        return ans;
    }

    private void dfs(TreeNode root, List<List<Pair>> cols,
                     int row, int col, int offset) {
        if (root == null) return;

        cols.get(col + offset).add(new Pair(row, root.val));

        dfs(root.left, cols, row + 1, col - 1, offset);
        dfs(root.right, cols, row + 1, col + 1, offset);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}