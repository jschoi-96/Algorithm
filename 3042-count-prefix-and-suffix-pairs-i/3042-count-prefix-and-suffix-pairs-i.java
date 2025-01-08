class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    res++;
                }
            }
        }
        return res;        
    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        if (!str2.startsWith(str1)) return false;
        if (!str2.endsWith(str1)) return false;
        return true;
    }
}