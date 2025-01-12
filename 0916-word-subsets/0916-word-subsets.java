class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();

        int [] maxFreq = new int[26];
        for(String word : words2) {
            int [] freq = new int[26];
            for(char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        for(String word : words1) {
            int [] wordFreq = new int[26];
            for(char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }

            boolean flag = true;
            for(int i = 0; i < 26; i++) {
                if (wordFreq[i] < maxFreq[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}