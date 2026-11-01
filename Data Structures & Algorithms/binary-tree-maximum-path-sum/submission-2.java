class Solution {
    int maxSum = Integer.MIN_VALUE;

    int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}