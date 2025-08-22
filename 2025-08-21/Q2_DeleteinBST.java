class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node to delete

            // Case 1: No left child
            if (root.left == null) return root.right;

            // Case 2: No right child
            if (root.right == null) return root.left;

            // Case 3: Two children
            TreeNode successor = findMin(root.right); // inorder successor
            root.val = successor.val;  // replace value
            root.right = deleteNode(root.right, successor.val); // delete successor
        }
        return root;
    }

    // helper: find the minimum node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}