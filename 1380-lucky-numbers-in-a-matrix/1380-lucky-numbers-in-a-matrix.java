class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] rowMin = new int[row];
        int[] colMax = new int[col];

        for(int i = 0; i < row; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < col; j++){
                min = Math.min(min, matrix[i][j]);
            }
            rowMin[i] = min;
        }

        for(int j = 0; j < col; j++){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < row; i++){
                max = Math.max(max, matrix[i][j]);
            }
            colMax[j] = max;
        }

        List<Integer> lucky = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]){
                    lucky.add(matrix[i][j]);
                }
            }
        }

        return lucky;
    }
}