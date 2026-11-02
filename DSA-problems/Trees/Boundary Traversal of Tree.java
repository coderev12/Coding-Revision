//  PS: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root.left != null || root.right != null) ans.add(root.data);
        if(root.left != null) leftBoundary(root.left,ans);
        leafNodeTraversal(root,ans);
        ArrayList<Integer> right = new ArrayList<>();
        if(root.right != null) rightBoundary(root.right,right);
        Collections.reverse(right);
        ans.addAll(right);
        return ans;
    }
    public static void leafNodeTraversal(Node root, ArrayList<Integer> leafNodes){
        if(root == null){
            return;
        }
        leafNodeTraversal(root.left,leafNodes);
        if(root.right == null && root.left == null){
            leafNodes.add(root.data);
        }   
        leafNodeTraversal(root.right,leafNodes);
    }
    public static void leftBoundary(Node root,ArrayList<Integer> leftboundary){
        if(root.left == null && root.right == null){
            return;
        }
        
        if(root.left != null) {
            leftboundary.add(root.data);
            leftBoundary(root.left,leftboundary);
        }else{
            leftboundary.add(root.data);
            leftBoundary(root.right,leftboundary);
        }   
        return;
    }
    public static void rightBoundary(Node root,ArrayList<Integer> rightBoundary){
        if(root.left == null && root.right == null){
            return;
        }
        
        if(root.right != null) {
            rightBoundary.add(root.data);
            rightBoundary(root.right,rightBoundary);
        }else{
            rightBoundary.add(root.data);
            rightBoundary(root.left,rightBoundary);
        }   
        return;
    }
}