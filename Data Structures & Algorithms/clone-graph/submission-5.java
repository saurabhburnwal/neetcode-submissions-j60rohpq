/*
Definition for a Node.
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
class Solution {
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return traverse(node);
    }

    private Node traverse(Node node) {
        if (node == null)  return null;
        if (map.containsKey(node))  return map.get(node);
        map.putIfAbsent(node, new Node(node.val));

        for (Node n : node.neighbors) {
            map.get(node).neighbors.add(traverse(n));
        }

        return map.get(node);
    }
}
