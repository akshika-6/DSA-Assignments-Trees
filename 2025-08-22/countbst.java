public class countbst {
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
    int getCount(Node root, int l, int h) {
        // Your code here
        if (root == null) {
            return 0;
        }

        
        if (root.data >= l && root.data <= h) {
            return 1 + this.getCount(root.left, l, h) + this.getCount(root.right, l, h);
        }
    
        else if (root.data < l) {
            return this.getCount(root.right, l, h);
        }
        
        else {
            return this.getCount(root.left, l, h);
        }
    }
}
}
