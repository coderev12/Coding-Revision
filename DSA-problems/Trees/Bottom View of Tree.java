// PS:https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
class Pair{
    Node node;
    int horizontalDistanceOfEachNode;
    
    Pair(Node passedNode, int horizontalDistance){
        node = passedNode;
        horizontalDistanceOfEachNode = horizontalDistance;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        TreeMap<Integer, ArrayList<Integer>> verticalOrderTraversalMap = new TreeMap<>();
        
        Queue<Pair> traversalQueue = new LinkedList<>();
        
        traversalQueue.add(new Pair(root,0));
        
        while(!traversalQueue.isEmpty()){
            Pair currPair = traversalQueue.poll();
            Node currNode = currPair.node;
            int currNodeHorizontalVal = currPair.horizontalDistanceOfEachNode;
            if(verticalOrderTraversalMap.containsKey(currNodeHorizontalVal)){
                verticalOrderTraversalMap.get(currNodeHorizontalVal).add(currNode.data);
            }else{
                verticalOrderTraversalMap.put(currNodeHorizontalVal, new ArrayList<Integer>());
                verticalOrderTraversalMap.get(currNodeHorizontalVal).add(currNode.data);
            }
            if(currNode.left != null){
                traversalQueue.offer(new Pair(currNode.left,currNodeHorizontalVal - 1));
            }
            if(currNode.right != null){
                traversalQueue.offer(new Pair(currNode.right,currNodeHorizontalVal + 1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (ArrayList<Integer> list : verticalOrderTraversalMap.values()) {
            ans.add(list.get(list.size() - 1));
        }

      return ans;
    }
}