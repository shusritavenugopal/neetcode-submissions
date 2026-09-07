class Solution {

    int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    int m, n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> rotten = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rotten.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;
        while(!rotten.isEmpty() && fresh > 0) {
            int size = rotten.size();

            for (int i = 0; i < size; i++) {
                int[] current = rotten.poll();
                int row = current[0];
                int col = current[1];

                for (int[] direction: directions) {
                    int nextRow = direction[0] + row;
                    int nextCol = direction[1] + col;

                    if (isValid(nextRow, nextCol, grid)) {
                        rotten.offer(new int[]{nextRow, nextCol});
                        fresh--;
                        grid[nextRow][nextCol] = 2;
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes: -1;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        return (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1);
    }
}
