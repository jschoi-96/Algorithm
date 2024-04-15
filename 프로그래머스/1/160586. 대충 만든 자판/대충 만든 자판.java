import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int ans_idx = 0;
        for(String target : targets) {
            
            for(int i = 0; i < target.length(); i++){
                
                int dist = 101;
                char c = target.charAt(i);
                
                for(String key : keymap) {
                    int idx = key.indexOf(c);
                    if (idx == -1) continue;
                    else if (idx < dist) dist = idx;
                }
                
                if (dist > 100) {
                    answer[ans_idx] = -1;
                    break;
                }
                else answer[ans_idx] += dist + 1;
            }
            ans_idx++;
        }
        return answer;
    }
}