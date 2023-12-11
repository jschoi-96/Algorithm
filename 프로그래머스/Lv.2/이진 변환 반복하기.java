import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0; int rid = 0;
        // replace를 사용하여 계속 줄여나가기?
        
        while(s.length() != 1) {
            
            for(int i = 0; i < s.length(); i++){
                char target = s.charAt(i);
                if (target == '0') {
                    rid++;
                }
            }
            s = s.replace("0" , "");
            int len = s.length();
            
            StringBuilder sb = new StringBuilder();
            while(len > 0) {
                if (len % 2 != 0) sb.append("1");
                else sb.append("0");
                len /= 2;
            }
            count++;
            s = sb.toString();
        }
        
        answer[0] = count;
        answer[1] = rid;
        return answer;
    }
}

// Integer.toBinaryString을 사용한 풀이

import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0; int rid = 0;
        
        while(s.length() != 1) {
            
            int original_len = s.length();
            s = s.replace("0" , "");
            
            int len = s.length();
            rid += original_len - len;
            count++;
            s = Integer.toBinaryString(len);;
        }
        
        answer[0] = count;
        answer[1] = rid;
        return answer;
    }
}
