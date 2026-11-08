class Solution {

    void dfs(int i, int j, int n, int m, int[][] grid, int cnt) {

        if (i < 0 || i >= n || j < 0 || j >= m)
            return;

        if (grid[i][j] == -1 || (grid[i][j] != Integer.MAX_VALUE && grid[i][j] <= cnt))
            return;

        grid[i][j] = cnt;

        dfs(i + 1, j, n, m, grid, cnt + 1);
        dfs(i - 1, j, n, m, grid, cnt + 1);
        dfs(i, j + 1, n, m, grid, cnt + 1);
        dfs(i, j - 1, n, m, grid, cnt + 1);
    }

    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    // Start from treasure's neighbors
                    dfs(i + 1, j, n, m, grid, 1);
                    dfs(i - 1, j, n, m, grid, 1);
                    dfs(i, j + 1, n, m, grid, 1);
                    dfs(i, j - 1, n, m, grid, 1);
                }
            }
        }
    }
}