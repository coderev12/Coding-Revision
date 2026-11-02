// PS: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class Pair{
        Node n;
        int val;
        
        Pair(Node n1, int value){
            n = n1;
            val = value;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(!mp.containsKey(p.val)){
                mp.put(p.val,p.n.data);
            }
            
            if(p.n.left != null){
                q.offer(new Pair(p.n.left,p.val - 1));
            }
            if(p.n.right != null){
                q.offer(new Pair(p.n.right,p.val + 1));
            }
            
        }
        //System.out.println(mp);
        
      return new ArrayList<>(mp.values());
    }
}