class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) continue;

            boolean forward = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {

                int nextSlow = getNext(nums, slow);
                if ((nums[nextSlow] > 0) != forward || nextSlow == slow)
                    break;

                int nextFast = getNext(nums, fast);
                if ((nums[nextFast] > 0) != forward || nextFast == fast)
                    break;

                nextFast = getNext(nums, nextFast);
                if ((nums[nextFast] > 0) != forward || nextFast == getNext(nums, nextFast))
                    break;

                slow = nextSlow;
                fast = nextFast;

                if (slow == fast)
                    return true;
            }

            int curr = i;

            while ((nums[curr] > 0) == forward) {

                int next = getNext(nums, curr);

                if (next == curr) {
                    nums[curr] = 0;
                    break;
                }

                nums[curr] = 0;
                curr = next;
            }
        }

        return false;
    }

    private int getNext(int[] nums, int index) {
        int n = nums.length;
        return ((index + nums[index]) % n + n) % n;
    }
}