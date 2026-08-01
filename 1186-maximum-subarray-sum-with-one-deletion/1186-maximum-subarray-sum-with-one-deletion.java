class Solution {
    public int maximumSum(int[] arr) {
        int keep = arr[0];
        int delete = 0;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int oldKeep = keep;

            keep = Math.max(arr[i], keep + arr[i]);

            delete = Math.max(oldKeep, delete + arr[i]);

            ans = Math.max(ans, Math.max(keep, delete));
        }

        return ans;
    }
}