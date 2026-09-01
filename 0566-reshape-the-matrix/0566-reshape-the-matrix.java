class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return mat;
        }

        int row = mat.length;
        int col = mat[0].length;

        if (r * c != row * col) {
            return mat;
        }

        int[][] reshape = new int[r][c];
        int n_row = 0;
        int n_col = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                reshape[n_row][n_col] = mat[i][j];
                n_col++;

                if (n_col == c) {
                    n_col = 0;
                    n_row++;
                }
            }
        }

        return reshape;
    }
}