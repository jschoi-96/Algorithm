import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            String tmp = "";
            String s1 = convert(n, arr1[i]);
            String s2 = convert(n, arr2[i]);
            for(int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == '1' || s2.charAt(j) == '1') tmp += "#";
                else tmp += " ";
            }
            //System.out.println(tmp);
            answer[i] = tmp;
        }
        return answer;
    }
    
    public String convert(int n, int num) {
        String s = Integer.toBinaryString(num);
        
        while(s.length() < n) {
            s = "0" + s;
        }
        return s;
    }
}