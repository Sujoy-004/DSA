class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int target = sum - k;

            ans += freq.getOrDefault(target, 0);

            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}