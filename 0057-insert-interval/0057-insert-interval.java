class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();

        if(intervals.length == 0){
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }

        int start, end;
        boolean inserted = false;

        if(newInterval[0] <= intervals[0][0]){
            start = newInterval[0];
            end = newInterval[1];
            inserted = true;
        }
        else{
            start = intervals[0][0];
            end = intervals[0][1];
        }

        for(int i = 0; i < intervals.length; i++){
            if(i == 0 && !inserted) continue;

            int inner_start = intervals[i][0];
            int inner_end = intervals[i][1];

            if(!inserted && newInterval[0] <= inner_start){
                if(newInterval[0] <= end){
                    end = Math.max(end, newInterval[1]);
                }
                else{
                    list.add(new int[]{start, end});
                    start = newInterval[0];
                    end = newInterval[1];
                }
                inserted = true;
            }

            if(inner_start <= end){
                end = Math.max(end, inner_end);
            }
            else{
                list.add(new int[]{start, end});
                start = inner_start;
                end = inner_end;
            }
        }

        if(!inserted){
            if(newInterval[0] <= end){
                end = Math.max(end, newInterval[1]);
            }
            else{
                list.add(new int[]{start, end});
                start = newInterval[0];
                end = newInterval[1];
            }
        }

        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }
}