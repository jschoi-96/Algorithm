import java.util.*;
class Solution {
    // 1. 여분을 가지고 있는 학생이 도난 당한 경우, 해당 학생은 체육복을 입음. 이 때 값들을 초기화 해줘야함
    // 2. 도난당한 학생들의 번호와 여분 학생들의 번호를 비교하여 일치 하는 경우, 값을 초기화.
    // 3. 값을 초기화 한 경우, 해당 도난은 처리가 된 것이므로 break를 통해 다음 학생으로 넘어가야 함. 
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int cnt = 0;
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i]) { // 여분을 가지고있는 학생이 도난당한경우
                    reserve[j] = -1;
                    lost[i] = -1;
                    cnt++;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    cnt++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        int cur = n - lost.length;
        return cur + cnt;
    }
}