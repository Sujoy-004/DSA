class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int res = 0;
        int zeroCount = 0;

        for(int high = 0; high < n; high++){
            if(nums[high] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[low] == 0){
                    zeroCount--;
                }
                low++;
            }
            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}