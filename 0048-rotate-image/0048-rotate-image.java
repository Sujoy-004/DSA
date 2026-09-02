class Solution {
    public void rotate(int[][] matrix /* int degrees */) {
        int n = matrix.length;
        /*
        normalize the degree
        degrees = degrees % 360;
        if(degrees < 0){
            degrees += 360;
        }

        int times = degrees / 90;

        for(int k = 0; k < times; k++){
            // code for trnspose
            // code for reversing each row
        }
        */

        // trnspose 
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reversing each row
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}