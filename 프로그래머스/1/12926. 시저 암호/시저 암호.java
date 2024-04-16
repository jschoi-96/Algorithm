class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += " ";
                continue;
            }
            char c = s.charAt(i);
            char lower = Character.toLowerCase(c);
           
            // 더했을때 알파벳이 'z'를 넘어가는 경우
            int check = lower + n - 'a';
            if (check >= 26) {
                check -= 26;
            }
            
            if (Character.isUpperCase(c)) {
               answer += Character.toUpperCase((char) (check + 'a'));
            }
            else answer += (char) (check + 'a');
        }
        return answer;
    }
}