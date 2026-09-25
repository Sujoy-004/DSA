class Solution{
    public int numberOfSubarrays(int[] nums, int k){
        int low = 0, res = 0, count = 0;
        int firstOdd = 0;

        for(int high = 0; high < nums.length; high++){
            if(nums[high] % 2 != 0){
                count++;
            }

            while(count > k){
                if(nums[low] % 2 != 0){
                    count--;
                }
                low++;
            }

            if(count == k){
                int temp = low;
                while(nums[temp] % 2 == 0){
                    temp++;
                }

                res += temp - low + 1;
            }
        }

        return res;
    }
}