class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int maxAns = nums[0];
        int minSum = nums[0];
        int minAns = nums[0];
        int total = nums[0];

        for(int i=1; i<nums.length; i++){
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            maxAns = Math.max(maxSum, maxAns);

            minSum = Math.min(nums[i], minSum + nums[i]);
            minAns = Math.min(minSum, minAns);

            total += nums[i];
        }

        if(maxAns < 0){
            return maxAns;
        }

        return Math.max(maxAns, total-minAns);
    }
}