import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int n = completion.length;
        
        for(int i = 0; i < n; i++) {
            // System.out.println(participant[i] + " " + completion[i]);
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        
        
        return participant[n];
    }
}