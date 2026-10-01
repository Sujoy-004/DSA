class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1001];
        
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            
            locations[start] += numPassengers;
            locations[end] -= numPassengers;
        }
        
        for (int numPassengers : locations) {
            capacity -= numPassengers;
            if (capacity < 0) {
                return false;
            }
        }
        
        return true;
    }
}