class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while(left < right){
            int shortWall;
            if(height[left] < height[right]){
                shortWall = height[left];
            }
            else{
                shortWall = height[right];
            }

            int width = right - left;

            int area = width * shortWall;

            if(area > res){
                res = area;
            }

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return res;
    }
}