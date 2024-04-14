class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int win_count = 0;
        int zero = 0;
      
        for(Integer lotto : lottos) {
            if (lotto == 0) {
                zero++;
            }
            for(Integer win : win_nums) {
               
                if (win == lotto) {
                    win_count++;
                    break;
                }
                
            }
        }
        int [] result = new int[2];
        result[0] = win_count + zero;
        result[1] = win_count;
        for(int i = 0; i < result.length; i++) {
            if (result[i] == 6) answer[i] = 1;
            else if (result[i] == 5) answer[i] = 2;
            else if (result[i] == 4) answer[i] = 3;
            else if (result[i] == 3) answer[i] = 4;
            else if (result[i] == 2) answer[i] = 5;
            else answer[i] = 6;
        }
        return answer;
    }
}