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
    int maxDia;
    int height(TreeNode root, TreeNode parent){
        // System.out.println("parent is "+parent.val);
        if(root==null) return 0;
        int lh = height(root.left, root);
        // System.out.println("lh = "+lh);
        int rh = height(root.right, root);
        // System.out.println("rh = "+rh);
        maxDia = Math.max(maxDia, lh+rh);
        return 1+Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia=0;
        int lh = height(root.left, root);
        int rh = height(root.right, root);
        return Math.max(maxDia, lh+rh);
    }
}
