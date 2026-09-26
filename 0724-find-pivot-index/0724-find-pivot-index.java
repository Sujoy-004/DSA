class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i : nums){
            sum += i;
        }

        if(sum - nums[0] == 0) return 0;

        int left = nums[0];
        int right = 0;

        for(int i = 1; i < n; i++){

            right = sum - left - nums[i];

            if(left == right) return i;

            left += nums[i];
        }

        return -1;
    }
}