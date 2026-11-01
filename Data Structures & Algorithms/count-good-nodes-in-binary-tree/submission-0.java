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
    int count;
    void preOrder(TreeNode root, int maxParentVal){
        if(root==null) return;
        if(root.val >= maxParentVal){
            count++;
            maxParentVal = root.val;
        }
        preOrder(root.left, maxParentVal);
        preOrder(root.right, maxParentVal);

    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        count=1;
        preOrder(root.left, root.val);
        preOrder(root.right, root.val);
        return count;
    }
}
