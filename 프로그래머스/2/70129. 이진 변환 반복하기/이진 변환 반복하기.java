import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int convert = 1;
        int count = 0;
        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') sb.append(c);
                else {
                    count++;
                    flag = true; // 0이 하나라도 있으면 true
                }
            }
            
            if (flag) s = sb.toString();
            else { // 0이 없다면 이진 변환 해줘야함
                int n = sb.toString().length();
                s = Integer.toString(n,2);
                convert++;
            }
        }
        answer[0] = convert;
        answer[1] = count;
        return answer;
    }
}