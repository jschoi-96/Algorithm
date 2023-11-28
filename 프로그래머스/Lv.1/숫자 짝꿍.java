import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        // O(N) 시간복잡도에도 실패함. (테스트 11 ~ 15)
        
        int [] occurX = new int[10]; 
        int [] occurY = new int[10];
        int index = 0;
        
        for(int i = 0; i < X.length(); i++){
            occurX[X.charAt(i) - '0']++;
        }
        
        
        for(int i = 0; i < Y.length(); i++){
            occurY[Y.charAt(i) - '0']++;
        }
        
        for(int i = 9; i >= 0; i--) {
            while(occurX[i] > 0 && occurY[i] > 0) {
                answer.append(i);
                occurX[i]--;
                occurY[i]--;
            }
            // for(int j = 0; j < Math.min(occurX[i], occurY[i]); j++){
            //     answer.append(i);
            // }
        }
        
        if (answer.length() == 0) return "-1";
        if (answer.length() != 1 && answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}
