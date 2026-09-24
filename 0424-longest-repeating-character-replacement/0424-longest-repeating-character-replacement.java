class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        int fre = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int high = 0; high < s.length(); high++){
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            fre = Math.max(fre, map.get(ch));

            while((high-low+1) - fre > k){
                char left = s.charAt(low);
                int count = map.get(left) - 1;
                if(count == 0){
                    map.remove(left);
                }
                else{
                    map.put(left, count);
                }
                low++;
            }
            ans = Math.max(ans, high-low+1);
        }

        return ans;
    }
}