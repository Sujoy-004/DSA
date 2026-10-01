class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        int curr_start = points[0][0];
        int curr_end = points[0][1];

        for(int i = 1; i < points.length; i++){
            int next_start = points[i][0];
            int next_end = points[i][1];

            if(curr_end >= next_start){
                curr_end = Math.min(curr_end, next_end);
            }
            else{
                list.add(new int[]{curr_start, curr_end});
                curr_start = next_start;
                curr_end = next_end;
            }
        }
        list.add(new int[]{curr_start, curr_end});

        return list.size();
    }
}