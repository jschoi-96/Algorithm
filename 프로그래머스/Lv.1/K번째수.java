import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int st = commands[i][0];
            int en = commands[i][1];
            int [] tmp = new int[en-st+1]; // 총 길이는 + 1을 해줘야 함
            
            
            int idx = st - 1;
            for(int j = 0; j < tmp.length; j++){
                tmp[j] = array[idx++];
                
            }
            
            Arrays.sort(tmp);
            int res = commands[i][2];
            answer[i] = tmp[res - 1];
        }
        return answer;
    }
}
