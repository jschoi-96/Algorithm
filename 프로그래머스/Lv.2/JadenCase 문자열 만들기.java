import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String [] str = s.split(" ");
        
        // 반례 a b c 
        for(String st : str) {
            
            if (st.length() == 0) sb.append(" "); // 공백이 여러개일 때를 체크
            
            else {
                char first = st.charAt(0);

                if (!Character.isLetter(first)){ // 단어의 첫 문자가 숫자일때는 전부 소문자 처리
                    sb.append(st.toLowerCase()).append(" ");
                }

                else { // 첫 문자가 문자일 때는 
                    String test = String.valueOf(first).toUpperCase();
                    String rest = st.substring(1).toLowerCase();
                    sb.append(test).append(rest).append(" ");
                }
            }
            
            
        }
        
        if (s.charAt(s.length() - 1) == ' ') return sb.toString();
        return sb.toString().trim();
    }
}
