class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int inner_start = intervals[i][0];
            int inner_end = intervals[i][1];

            if (inner_start <= end) {
                end = Math.max(end, inner_end);
            } else {
                list.add(new int[]{start, end});
                start = inner_start;
                end = inner_end;
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }
}