class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        int low = 0, matched = 0, start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

            if (map2.containsKey(ch) && map1.get(ch).equals(map2.get(ch))) {
                matched++;
            }

            while (matched == map2.size()) {
                if (high - low + 1 < minLen) {
                    minLen = high - low + 1;
                    start = low;
                }

                char left = s.charAt(low);
                map1.put(left, map1.get(left) - 1);

                if (map2.containsKey(left) && map1.get(left) < map2.get(left)) {
                    matched--;
                }
                low++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}