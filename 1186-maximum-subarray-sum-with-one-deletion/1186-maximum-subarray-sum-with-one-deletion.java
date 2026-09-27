class Solution {
    public int maximumSum(int[] nums) {
        int keep = nums[0];
        int delete = 0;
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int oldKeep = keep;
            keep = Math.max(nums[i], keep + nums[i]);
            delete = Math.max(oldKeep, delete + nums[i]);
            res = Math.max(res, Math.max(keep, delete));
        }

        return res;
    }
}