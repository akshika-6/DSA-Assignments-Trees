import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class binarytree_bst {
    /*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */

class Solution {
    int idx = 0;
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root) {
        // Your code here
        if (root == null) return null;

        // 1. Collect values
        List<Integer> values = new ArrayList<>();
        collectValues(root, values);

        // 2. Sort values
        Collections.sort(values);

        // 3. Reassign values in inorder order
        idx = 0;
        assignValues(root, values);

        return root;
    }

    // Inorder traversal to collect values
    private void collectValues(Node node, List<Integer> values) {
        if (node == null) return;
        collectValues(node.left, values);
        values.add(node.data);
        collectValues(node.right, values);
    }

    // Inorder traversal to assign sorted values
    private void assignValues(Node node, List<Integer> values) {
        if (node == null) return;
        assignValues(node.left, values);
        node.data = values.get(idx++);
        assignValues(node.right, values);
    }
}
}
