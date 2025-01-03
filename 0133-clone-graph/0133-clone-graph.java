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

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> visited = new HashMap<>();
        Node newNode = new Node(node.val);
        visited.put(newNode.val, newNode);

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nxt : cur.neighbors) {
                if (!visited.containsKey(nxt.val)) {
                    Node nxtNode = new Node(nxt.val);
                    visited.put(nxt.val, nxtNode);
                    q.add(nxt);
                }

                visited.get(cur.val).neighbors.add(visited.get(nxt.val));
            }
        }
        return newNode;
    }
}