import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++){
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            if (choices[i] < 4) { // 1 ~ 3일떄 앞쪽 문자열의 정보 갱신
                int idx = map.getOrDefault(first, 0);
                map.put(first, idx += 4 - choices[i]);
            }
            
            else if (choices[i] > 4) { // 5 ~ 7 일때 뒤쪽 문자열 정보 갱신
                int idx = map.getOrDefault(second, 0);
                map.put(second, idx += choices[i] - 4);
            }
        }
        
        
        answer += (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) ? 'R' : 'T';
        answer += (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) ? 'C' : 'F';
        answer += (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) ? 'J' : 'M';
        answer += (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) ? 'A' : 'N';
        return answer;
    }
}
