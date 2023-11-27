import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++){
            
            if (babbling[i].contains("ayaaya") || babbling[i].contains("yeye")
               || babbling[i].contains("woowoo") || babbling[i].contains("mama")) continue;
            babbling[i] = babbling[i].replace("aya" , " ");
            babbling[i] = babbling[i].replace("ye" , " ");
            babbling[i] = babbling[i].replace("woo" , " ");
            babbling[i] = babbling[i].replace("ma" , " ");
            babbling[i] = babbling[i].replace(" " , "");
            
            if (babbling[i].length() == 0) answer++;
        }
        
        // 반례  ["yayae"] 
        // 이것 때문에 replace(" ")이 아닌 ("")로 먼저 처리
        
        return answer;
    }
}
