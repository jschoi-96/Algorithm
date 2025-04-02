import java.util.*;
class Solution {
    
    String [] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                sb.append(c);
            }
            
            else {
                tmp += c;
                for(int j = 0; j < str.length; j++) {
                    if (tmp.equals(str[j])) {
                        sb.append(j);
                        tmp = ""; // 초기화
                        break;
                    }
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }

}