class Solution {
    public int findMaxLength(int[] nums) {

        int n = nums.length;

        int zero = 0;
        int one = 0;

        int diff = 0;
        int res = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, -1);

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                zero++;
            }
            else if (nums[i] == 1) {
                one++;
            }

            diff = zero - one;

            if (freq.containsKey(diff)) {
                res = Math.max(res, i - freq.get(diff));
            }
            else {
                freq.put(diff, i);
            }
        }

        return res;
    }
}