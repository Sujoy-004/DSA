class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int x : arr){
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        HashSet<Integer> s = new HashSet<>();
        for(int x : freq.values()){
            s.add(x);
        }

        return s.size() == freq.size();
    }
}