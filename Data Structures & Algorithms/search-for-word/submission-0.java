class Solution {

    int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    int m, n;
    boolean[][] seen;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        seen = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j= 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    if (dfs(board, word, i, j, 1)) {
                        return true;
                    } 
                    seen[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int nextIndex) {
        if (nextIndex == word.length()) {
            return true;
        }

        for (int[] direction: directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isValid(nextRow, nextCol) && 
            board[nextRow][nextCol] == word.charAt(nextIndex) &&
            !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                if (dfs(board, word, nextRow, nextCol, nextIndex + 1)) {
                    return true;
                }
                seen[nextRow][nextCol] = false;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}
