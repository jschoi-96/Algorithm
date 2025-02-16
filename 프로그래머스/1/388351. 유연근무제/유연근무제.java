class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int staff = timelogs.length;
        int answer = staff; // 모든 직원이 시간 지킨다고 가정 
        
        int days = startday;
        
        for(int i = 0; i < staff; i++) {
            days = startday; // 다시 기존 날짜로 초기화
            int start_time = schedules[i];
            int limit = start_time + 10;
            
            // 분이 60이 넘는경우 
            if (limit % 100 >= 60) limit += 40;
            
            for(int j = 0; j < 7; j++) {
                if (isWeekend(days)) {
                    //System.out.println("days: " + days);
                    days++;
                    continue; // 주말인 경우는 이벤트 영향 x
                }
                int time = timelogs[i][j];
                // if (time % 100 > 60) time += 40;
                
                if (time > limit) {
                    answer--;
                    break;
                }
                days++;
            }
            //System.out.println();
        }
        return answer;
    }
    
    public boolean isWeekend(int num) {
        return num == 6 || num == 7 || num == 13 || num == 14;
    }
}