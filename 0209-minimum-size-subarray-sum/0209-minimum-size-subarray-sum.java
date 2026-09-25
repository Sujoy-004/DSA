class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        for (int high = 0; high < nums.length; high++) {
            sum += nums[high];

            while (sum >= target) {
                minSum = Math.min(minSum, high - low + 1);
                sum -= nums[low];
                low++;
            }
        }

        return (minSum == Integer.MAX_VALUE) ? 0 : minSum;
    }
}