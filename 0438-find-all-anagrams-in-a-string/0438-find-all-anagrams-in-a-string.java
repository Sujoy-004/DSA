class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        int[] smap = new int[256]; 
        int[] pmap = new int[256];

        for(char c : p.toCharArray()){
            pmap[c]++;
        }

        int low=0;

        for(int high=0; high<s.length(); high++){
            char c = s.charAt(high);
            smap[c]++;

            if((high-low+1) > p.length()){
                char leftChar = s.charAt(low);
                smap[leftChar]--; 
                low++;
            }

            if((high-low+1) == p.length()){
                if(Arrays.equals(smap, pmap)){
                    res.add(low);
                }
            }
        }
        return res;
    }
}