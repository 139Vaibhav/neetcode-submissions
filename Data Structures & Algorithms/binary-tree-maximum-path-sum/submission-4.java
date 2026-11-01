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
    int maxS;
    int rec(TreeNode root){
        if(root==null) return 0;
        int lSum = Math.max(0,rec(root.left));
        int rSum = Math.max(0,rec(root.right));
        maxS = Math.max(maxS, root.val+lSum+rSum);
        // since we can either take a left or a right for a path
        return root.val + Math.max(lSum, rSum);
    }
    public int maxPathSum(TreeNode root) {
        // Algorithm -> maintain a global max (which we can get by left sum + right sum + cur val)
        // Also when we want a path, so we can either take the left sum or the right sum, so in this case take root val + math.mac(left sum , right sum)
        maxS=Integer.MIN_VALUE;
        int x = rec(root);
        return maxS;
    }
}
