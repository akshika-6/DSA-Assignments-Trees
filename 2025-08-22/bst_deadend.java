public class bst_deadend {
    /*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        // Code here.
         return hasDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    private boolean hasDeadEnd(Node node, int min, int max) {
        if (node == null) return false;

        // If the allowed range is a single number,
        // we cannot insert any new node here.
        if (min == max) return true;

        return hasDeadEnd(node.left, min, node.data - 1) ||
               hasDeadEnd(node.right, node.data + 1, max);
    }
}
}
