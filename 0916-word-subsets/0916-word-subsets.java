class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> res = new ArrayList<>();

        Map<Character, Integer> maxFreqMap = new HashMap<>();
        for (String word : words2) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
            for (char c : freqMap.keySet()) {
                maxFreqMap.put(c, Math.max(maxFreqMap.getOrDefault(c, 0), freqMap.get(c)));
            }
        }

        for (String word : words1) {
            Map<Character, Integer> cntMap = new HashMap<>();
            for(char c : word.toCharArray()) {  
                cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
            }

            boolean flag = true;
            for (char key : maxFreqMap.keySet()) {
                if (!cntMap.containsKey(key) || cntMap.get(key) < maxFreqMap.get(key)) {
                    flag = false;
                    break;
                }
            }

            // l: 1, e:2, o: 2
            // leetcode -> l:1, e:3, o:1

            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}