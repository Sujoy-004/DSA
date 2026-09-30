class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for(int[] interval : intervals){
            list.add(interval);
        }
        list.add(newInterval);

        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] curr = list.get(0);

        for(int i = 1; i < list.size(); i++){
            int[] next = list.get(i);

            if(curr[1] >= next[0]){
                curr[1] = Math.max(curr[1], next[1]);
            }
            else{
                res.add(curr);
                curr = next;
            }
        }
        res.add(curr);

        return res.toArray(new int[res.size()][]);
    }
}