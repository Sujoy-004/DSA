class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int maxAns = nums[0];
        int minSum = nums[0];
        int minAns = nums[0];
        int total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            maxSum = Math.max(num, maxSum + num);
            maxAns = Math.max(maxAns, maxSum);

            minSum = Math.min(num, minSum + num);
            minAns = Math.min(minAns, minSum);

            total += num;
        }

        if (maxAns < 0) {
            return maxAns;
        }

        return Math.max(maxAns, total - minAns);
    }
}