class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> straight = new ArrayList<>();
        
        if(matrix.length == 0){
            return straight;   
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                straight.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                straight.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    straight.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    straight.add(matrix[i][left]);
                }
                left++;
            }
        }

        return straight;
    }
}