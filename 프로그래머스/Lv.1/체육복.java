import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
    
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 여벌 체육복을 가져온 학생이 도난 
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        
        // 여벌 체육복을 가져온 학생이 도난 x
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1; // 초기화를 해줘야 함 
                    break;
                }
            }
        }
        return answer;
    }
}
