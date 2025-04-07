class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        
        for(int i = 0; i < n; i++) {
            // 날짜
            int day = startday;
            int each = schedules[i];
            int cmp1 = cal(each);

            boolean flag = true;
            for(int j = 0; j < timelogs[i].length; j++) {
                if (isWeekend(day)) {
                    day++;
                    continue;
                }
                int time = timelogs[i][j];
                
                // 여기서 시간 * 100 + 분을 계산해줘야 함.
                int cmp2 = cal(time - 10);
                
                if (cmp2 > cmp1) { // 처음에 정해둔 시간을 초과한 경우
                    flag = false;
                    //break;
                }
                
                day++; // 날짜 하루씩 지남 
                // System.out.println("처음 시간: " + cmp1 + " cmp2: " + cmp2 + " day:  " + day);
                if (cmp2 > cmp1) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }
        return answer;
    }
    
    public int cal(int time) {
        int t = time; // 10을 빼줌
        
        int div = t % 100; // 나머지
        if (div >= 60) { // 60 이상인 경우엔 40을 빼줘서 정상처리 해줘야 함.
            t -= 40;
        }
        return t;
    }
    
    public boolean isWeekend(int day) {
        return day == 6 || day == 7 || day == 13 || day == 14 
            || day == 20 || day == 21 || day == 27 || day == 28;
    }
}