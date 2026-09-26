class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pdt = 1;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pdt *= nums[i];
            } else {
                zeroCount++;
            }
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                res[i] = pdt / nums[i];
            } else if (zeroCount == 1) {
                res[i] = (nums[i] == 0) ? pdt : 0;
            } else {
                res[i] = 0;
            }
        }

        return res;
    }
}