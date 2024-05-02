import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        boolean flag = true;
        for(int num : numbers) {
            if (num != 0) {
                flag = false;
                break;
            } 
        }
        
        if (flag) return "0";
        
        String [] str = new String[numbers.length];
        for(int i = 0; i < str.length; i++) str[i] = String.valueOf(numbers[i]);
        Arrays.sort(str, (n1, n2) -> {
            if (n1.charAt(0) != n2.charAt(0)) {
                return n1.charAt(0) - n2.charAt(0);
            }
            String s1 = n1 + n2;
            String s2 = n2 + n1;
            return s1.compareTo(s2);
        });
        
        
        for(int i = str.length - 1; i >= 0; i--) {
            answer += str[i];
        }
        
        return answer;
    }
}