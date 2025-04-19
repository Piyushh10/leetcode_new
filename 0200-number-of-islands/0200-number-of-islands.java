class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }

    public void bfs(int r, int c, int[][] vis, char[][] grid) {
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(r, c));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int column = q.peek().second;
            q.remove();

            int[] drow = { -1, 0, 1, 0 }; 
            int[] dcol = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = column + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}