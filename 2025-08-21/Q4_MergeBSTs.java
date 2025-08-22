/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // Write your code here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        return mergeSortedLists(list1, list2);
    }

    private void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    private ArrayList<Integer> mergeSortedLists(List<Integer> l1, List<Integer> l2) {
    ArrayList<Integer> merged = new ArrayList<>();
    int i = 0, j = 0;

    while (i < l1.size() && j < l2.size()) {
        if (l1.get(i) <= l2.get(j)) {
            merged.add(l1.get(i++));
        } else {
            merged.add(l2.get(j++));
        }
    }

    while (i < l1.size()) merged.add(l1.get(i++));
    while (j < l2.size()) merged.add(l2.get(j++));

    return merged;
    }
}
