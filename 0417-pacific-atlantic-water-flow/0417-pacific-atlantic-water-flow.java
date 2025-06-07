class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int row = heights.length, col = heights[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pac);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atl);
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, i,0, Integer.MIN_VALUE, pac);
            dfs(heights,i,col-1, Integer.MIN_VALUE, atl);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length)
            return;
        if (matrix[i][j] < prev || ocean[i][j])
            return;
        ocean[i][j] = true;
        for (int[] d : dir) {
            dfs(matrix, i + d[0], j + d[1], matrix[i][j], ocean);
        }
    }
}