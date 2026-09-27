class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int a = nums[i];
            int b = max * nums[i];
            int c = min * nums[i];

            min = Math.min(a, Math.min(b, c));
            max = Math.max(a, Math.max(b, c));

            res = Math.max(res, Math.max(max, min));
        }
        
        return res;
    }
}