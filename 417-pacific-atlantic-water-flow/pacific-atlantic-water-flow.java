class Solution {

    int m;
    int n;

    int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);
        }

        // Atlantic
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void dfs(int r, int c,
                    int[][] heights,
                    boolean[][] ocean) {

        if (ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= m ||
                nc < 0 || nc >= n) {
                continue;
            }

            if (heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, heights, ocean);
            }
        }
    }
}