class Solution {
    public int maximumWealth(int[][] accounts) {
        int rich = 0;
        for(int[] row : accounts){
            int sum = 0;
            for(int money : row){
                sum += money;
            }
            rich = Math.max(rich, sum);
        }
        return rich;
    }
}