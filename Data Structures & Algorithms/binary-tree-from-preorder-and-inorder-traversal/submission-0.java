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
    Map<Integer,Integer> mp;
    int idx;
    TreeNode build(int s, int e, int[] preorder){
        if(s>e) return null;
        int val = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(val);
        
        root.left = build(s, mp.get(val)-1, preorder);
        root.right = build(mp.get(val)+1, e, preorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder -> (root, left, right)
        // inorder -> (left, root, right)
        idx=0;
        mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i], i);
        }
        return build(0, inorder.length-1, preorder);
    }
}
