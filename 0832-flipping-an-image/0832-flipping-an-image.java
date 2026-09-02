class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] i : image){
            int left = 0;
            int right = i.length - 1;

            while(left <= right){
                int temp = i[right] ^ 1;
                i[right] = i[left] ^ 1;
                i[left] = temp;

                left++;
                right--;
            }
        }
        return image;
    }
}