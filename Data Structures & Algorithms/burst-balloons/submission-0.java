class Solution {
    private int[] arr;
    private int[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        memo = new int[n + 2][n + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, n + 1);
    }

    private int solve(int left, int right) {
        if (left + 1 >= right) {
            return 0;
        }
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int best = 0;
        for (int k = left + 1; k < right; k++) {
            int coins = solve(left, k)
                      + solve(k, right)
                      + arr[left] * arr[k] * arr[right];
            if (coins > best) {
                best = coins;
            }
        }

        memo[left][right] = best;
        return best;
    }
}