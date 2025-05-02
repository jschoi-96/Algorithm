import java.util.*;
class Solution {
    // 문자열을 1개 ~ s/2까지 자르면서 판단 
    public int solution(String s) {
        
        if (s.length() == 1) return 1;
        
        
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        
        int cnt = 1;
        for(int i = 1; i <= len/2; i++) {
            // System.out.println(s.substring(0,i));
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i); // 1 ~ n/2까지 앞에 부분
            for(int j = i; j <= s.length(); j += i) {
                String cur;
                if (j + i > s.length()) cur = s.substring(j);
                else cur = s.substring(j, j + i);
                
                //System.out.println(cur);
                
                if (base.equals(cur)) { // 문자열이 같은경우
                    cnt++;
                }
                
                else {
                    if (cnt > 1) sb.append(cnt).append(base);
                    else sb.append(base);
                    cnt = 1;
                    base = cur;
                }
                
                //sb.append(cur);
            }
            sb.append(base);
            // System.out.println(sb);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}