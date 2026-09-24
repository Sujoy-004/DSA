class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        int low = 0;
        int high = k - 1;

        for(int i = 0; i <= high; i++){
            sum += nums[i];
        }

        while(high < nums.length){
            res = Math.max(res, sum);

            sum -= nums[low];
            low++;
            high++;

            if(high >= nums.length){
                break;
            }

            sum += nums[high];
        }

        return (double)res/k;
    }
}