import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<>();
        int n = survey.length;
        
        for(int i = 0; i < n; i++) {
            int choice = choices[i];
            String sur = survey[i];
            if (choice < 4) { // 1 ~ 3일 때
                int score = 4 - choice;
                char c = sur.charAt(0);
                map.put(c, map.getOrDefault(c, 0) + score);
            }
            
            else if (choice > 4) {
                int score = choice - 4;
                char c = sur.charAt(1);
                map.put(c, map.getOrDefault(c, 0) + score);
            }
        }
        
        answer += (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) ? 'R' : 'T';
        answer += (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) ? 'C' : 'F';
        answer += (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) ? 'J' : 'M';
        answer += (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) ? 'A' : 'N';
        return answer;
    }
}