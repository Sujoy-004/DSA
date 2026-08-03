class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k  <= 1) return 0;

        int low = 0, res = 0, pdt = 1;

        for(int high=0; high<nums.length; high++){
            pdt *= nums[high];

            while(pdt >= k){
                pdt /= nums[low];
                low++;
            }
            res+=(high-low+1);
        }
        return res;
    }
}