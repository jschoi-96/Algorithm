class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (c == ' ') answer.append(c);
            
            if (c >= 'a' && c <= 'z') {
                
                if (c + n > 'z') answer.append((char) (c + n - 26));
                else answer.append((char)(c + n));
            }
            
            else if (c >= 'A' && c <= 'Z') {
                
                if (c + n > 'Z') answer.append((char) (c + n - 26));
                else answer.append((char)(c + n));
            }
        }
        return answer.toString();
    }
}
