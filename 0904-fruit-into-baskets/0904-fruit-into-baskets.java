class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0;
        int maxFruit = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int high = 0; high < fruits.length; high++){
            int fruit = fruits[high];
            map.put(fruit, map.getOrDefault(fruit, 0)+1);

            while(map.size() > 2){
                int left = fruits[low];
                int count = map.get(left) - 1;
                if(count == 0) map.remove(left);
                else map.put(left, count);
                low++;
            }
            maxFruit = Math.max(maxFruit, (high - low + 1));
        }

        return maxFruit;
    }
}