class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if (s.length() != 4 && s.length() != 6) return false;
        for(char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        return answer;
    }
}