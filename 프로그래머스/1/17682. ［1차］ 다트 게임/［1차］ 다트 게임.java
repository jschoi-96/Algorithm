import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int [] arr = new int[3];
        int idx = 0;
        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if (c == 'S') {
                int num = convert(i, dartResult);
                arr[idx++] = num;
            }
            else if (c == 'D') {
               int num = (int)Math.pow(convert(i, dartResult), 2);
                arr[idx++] = num;
            }
            
            else if (c == 'T') {
                int num = (int)Math.pow(convert(i, dartResult), 3);
                arr[idx++] = num;
            }
           
            else if (c == '*') {
                arr[idx-1] *= 2;
                if (idx - 2 < 0) continue;
                arr[idx-2] *= 2;
            }
            
            else if (c == '#') {
                if (idx - 1 < 0) continue;
                arr[idx-1] *= -1;
            }
        }
        
       for(int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer;
    }
    
    public int convert(int i, String dartResult) {
        int num = Integer.parseInt(dartResult.substring(i-1,i));
        if (i - 2 >= 0 && num == 0 && dartResult.substring(i-2,i-1).equals("1")) {
            return 10;
        }
        return num;
    }
}