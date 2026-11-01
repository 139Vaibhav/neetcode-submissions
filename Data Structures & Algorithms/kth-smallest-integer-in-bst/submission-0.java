/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> l;
    void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        l.add(root.val);
        inOrder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        // We know that inorder (left, root, right) traversal of a BST gives a sorted array
        l = new ArrayList<>();
        inOrder(root);
        return l.get(k-1);
    }
}
