// PS: http://geeksforgeeks.org/problems/burning-tree/1
/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/

class Solution {
    public int minTime(Node root, int target) {
        // code here
        Map<Node, Node> mapping = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node front = q.remove();
            if(front.left != null){
                mapping.put(front.left,front);
                q.offer(front.left);  
            } 
            if(front.right != null) {
                mapping.put(front.right,front);
                q.offer(front.right);
            }
            
        }
        Node targetNode = findNode(root,target);
        //System.out.println(targetNode.data);
        Queue<Node> bfs = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        bfs.offer(targetNode);
        visited.add(targetNode);
        int time = 0;
        while(!bfs.isEmpty()){
            //System.out.println(bfs);
            int size = bfs.size();
            for(int i = 0;i<size;i++){
                Node qq = bfs.remove();
                if(qq.left != null && !visited.contains(qq.left)) {
                    bfs.offer(qq.left);
                }
                if(qq.right != null && !visited.contains(qq.right)) {
                    bfs.offer(qq.right);
                }
                
                if(mapping.containsKey(qq) && !visited.contains(mapping.get(qq))) {
                    bfs.offer(mapping.get(qq));
                }
                visited.add(qq);
            }
            time++;
        }
        return time - 1;
    }
    
    public static Node findNode(Node root, int target){
        if(root == null) return null;
        if(root.data == target) return root;
        
        Node left = findNode(root.left,target);
        if(left != null) return left;
        return findNode(root.right,target);
        
    }
}