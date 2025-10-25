import java.util.ArrayList;

public class brothersdiffnodes {
    /*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    public static int countPairs(Node root1, Node root2, int x) {
        // code here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Get inorder traversal of both BSTs
        inorder(root1, list1);
        inorder(root2, list2);

        int i = 0;
        int j = list2.size() - 1;
        int count = 0;

        // Two-pointer technique
        while (i < list1.size() && j >= 0) {
            int sum = list1.get(i) + list2.get(j);

            if (sum == x) {
                count++;
                i++;
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
}
