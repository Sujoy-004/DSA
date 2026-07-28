class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0)
            return res;

        int wordLen = words[0].length();
        int totalWords = words.length;

        HashMap<String, Integer> target = new HashMap<>();

        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {

            HashMap<String, Integer> window = new HashMap<>();

            int low = offset;
            int wordCount = 0;

            for (int high = offset; high + wordLen <= s.length(); high += wordLen) {

                String word = s.substring(high, high + wordLen);

                if (!target.containsKey(word)) {

                    window.clear();
                    wordCount = 0;
                    low = high + wordLen;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                wordCount++;

                while (window.get(word) > target.get(word)) {

                    String leftWord = s.substring(low, low + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);

                    if (window.get(leftWord) == 0) {
                        window.remove(leftWord);
                    }

                    low += wordLen;
                    wordCount--;
                }

                if (wordCount == totalWords) {

                    res.add(low);

                    String leftWord = s.substring(low, low + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);

                    if (window.get(leftWord) == 0) {
                        window.remove(leftWord);
                    }

                    low += wordLen;
                    wordCount--;
                }
            }
        }

        return res;
    }
}