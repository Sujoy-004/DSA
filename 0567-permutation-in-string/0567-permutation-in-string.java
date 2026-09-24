class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int low = 0;
        for (int high = 0; high < s2.length(); high++) {
            char ch = s2.charAt(high);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            while (high - low + 1 > n) {
                char left = s2.charAt(low);
                int count = map2.get(left) - 1;
                if (count == 0){
                    map2.remove(left);
                }
                else{
                    map2.put(left, count);
                }
                
                low++;
            }

            if (high - low + 1 == n && map1.equals(map2)) return true;
        }

        return false;
    }
}