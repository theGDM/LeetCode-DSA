/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//TC : O(v + E)
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){ //edge case
            return null;
        }
        
        HashMap<Integer, Node> visited = new HashMap<>();
        return helper(node, visited);
    }
    
    public Node helper(Node node, HashMap<Integer, Node> visited){
        Node nodeClone = new Node(node.val); //make the clone node
        visited.put(node.val, nodeClone); //mark that, this val node is already cloned
        
        for(Node nbr : node.neighbors){
            if(visited.containsKey(nbr.val) == false){
                Node nbrClone = helper(nbr, visited);
                nodeClone.neighbors.add(nbrClone);
            }else{
                Node nbrClone = visited.get(nbr.val);
                nodeClone.neighbors.add(nbrClone);
            }
        }
        
        return nodeClone;
    }
}

//TC : O(v + E)
//Array is always faster than hashmap
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){ //edge case
            return null;
        }
        
        Node[] visited = new Node[101];
        return helper(node, visited);
    }
    
    public Node helper(Node node, Node[] visited){
        Node nodeClone = new Node(node.val); //make the clone node
        visited[node.val] = nodeClone; //mark that, this val node is already cloned
        
        for(Node nbr : node.neighbors){
            if(visited[nbr.val] == null){
                Node nbrClone = helper(nbr, visited);
                nodeClone.neighbors.add(nbrClone);
            }else{
                Node nbrClone = visited[nbr.val];
                nodeClone.neighbors.add(nbrClone);
            }
        }
        
        return nodeClone;
    }
}
