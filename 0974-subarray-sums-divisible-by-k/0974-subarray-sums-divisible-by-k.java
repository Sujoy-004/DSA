class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = ((sum % k) + k) % k;

            ans += freq.getOrDefault(rem, 0);

            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
}