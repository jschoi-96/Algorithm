import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int ans_idx = 0;
        for(int [] command: commands) {
            int start = command[0];
            int end = command[1];
            int target = command[2];
            
            int [] temp = new int[end - start + 1];
            int idx = 0;
            for(int i = start-1; i < end; i++) {
                temp[idx++] = array[i];
            }
            
            Arrays.sort(temp);
            answer[ans_idx++] = temp[target-1];
        }
        return answer;
    }
}