class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0;
        int len = 0;

        for(int high = 0; high < s.length(); high++){
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(map.get(ch) > 1){
                char left = s.charAt(low);
                map.put(left, map.get(left) - 1);
                low++;
            }

            len = Math.max(len, high-low+1);
        }

        return len;
    }
}