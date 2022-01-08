/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

// 1. when we insert into the DDL, we keep insert into the end of DDL
// 2. but in the end we need to link first and last node as well
class Solution {
    Node first;
    Node last;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }
    
    private void helper(Node node) {
        if (node != null) {
            helper(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
                last = node;
            } else {
                first = node;
                last = node;
            }
            // processing
            helper(node.right);
        }
    }
}