// PS: https://www.geeksforgeeks.org/problems/children-sum-parent/1
/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        return check(root) > -1 ? true: false;
    }
    public static int check(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        int left = check(root.left);
        if(left == -1) return -1;
        int right = check(root.right);
        if(right == -1) return -1;
       // System.out.println(left + " " + right);
        if(left + right != root.data) return -1;
        
        return root.data;
        
    }
}