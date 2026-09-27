class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            best = Math.max(best + num, num);
            res = Math.max(res, best);
        }

        return res;
    }
}