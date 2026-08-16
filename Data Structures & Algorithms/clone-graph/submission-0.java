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
private Map<Node, Node> map = new HashMap<>();
private boolean[] visited = new boolean[101];
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)   return null;
        traverse(node);
        return map.get(node);
    }

    private void traverse(Node node) {
        if (node == null || visited[node.val])  return;
        if (!map.containsKey(node)) map.put(node, new Node(node.val));
        visited[node.val] = true;
        for (Node n : node.neighbors) {
            if (!map.containsKey(n))    map.put(n, new Node(n.val));
            map.get(node).neighbors.add(map.get(n));
            traverse(n);
        }
    }
}
