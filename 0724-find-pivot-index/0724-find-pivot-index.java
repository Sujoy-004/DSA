class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;

        for (int x : nums) {
            sum += x;
        }

        // Check index 0
        left = 0;
        right = sum - nums[0];
        if (left == right) return 0;

        left = nums[0];

        for (int i = 1; i < n; i++) {
            right = sum - left - nums[i];

            if (left == right) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}