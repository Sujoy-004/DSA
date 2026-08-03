class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0];
        int maxAns = nums[0];
        int minAns = nums[0];

        for( int i = 1; i < nums.length; i++){
            maxEnd = Math.max(nums[i], maxEnd + nums[i]);
            maxAns = Math.max(maxEnd, maxAns);

            minEnd = Math.min(nums[i], minEnd + nums[i]);
            minAns = Math.min(minEnd, minAns);
        }

        return Math.max(maxAns, -minAns);
    }
}