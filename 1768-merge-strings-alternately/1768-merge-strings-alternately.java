class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i = 0; i < word1.length() + word2.length(); i++) {
            if (idx < word1.length()) sb.append(word1.charAt(idx));
            if (idx < word2.length()) sb.append(word2.charAt(idx));
            idx++;
        }
        return sb.toString();
    }
}