/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        // add your code here.
         ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            // Traverse all nodes in the current diagonal
            while (node != null) {
                result.add(node.data);

                // If left child exists, enqueue for later diagonals
                if (node.left != null) {
                    q.add(node.left);
                }

                // Move right for same diagonal
                node = node.right;
            }
        }
        return result;
    }
}