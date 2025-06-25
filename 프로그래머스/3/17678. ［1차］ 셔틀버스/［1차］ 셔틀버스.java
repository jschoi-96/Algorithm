import java.util.*;
class Solution {
    static List<Integer> arrivalTimes = new ArrayList<>();
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        // 1. 셔틀이 도착하는 시간 계산
        int start = 9 * 60; // 9시부터 시작
        for(int i = 0; i < n; i++) {
            arrivalTimes.add(start + i * t); 
        }
        
        // 2. 크루 셔틀 대기 시간 계산 및 정렬 
        int a = timetable.length;
        int[] time = new int[a];
        for(int i = 0; i < a; i++) {
            String s = timetable[i];
            String[] str = s.split(":");
            time[i] = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        }
        
        Arrays.sort(time);
        
        // 3. 
        int idx = 0;
        
        int con = 0;
        for(int i = 0; i < arrivalTimes.size(); i++) {
            int shuttleTime = arrivalTimes.get(i);
            int cnt = 0;
            while(cnt < m && idx < time.length && time[idx] <= shuttleTime) {
                cnt++;
                idx++;
            }
            
            if (i == arrivalTimes.size() - 1) { // 마지막 셔틀
                if (cnt < m) { // 셔틀에 모두 탈 수 있음
                    con = shuttleTime;
                }
                
                else con = time[idx - 1] - 1; // 만석이라면 마지막 탑승자보다 일찍
            }
        }
        
        int div = con / 60, rem = con % 60;
        answer = convert(div, rem);
        return answer;
    }
    
    public String convert(int div, int rem) {
        String s1 = "", s2 = "";
        if (div < 10) s1 += "0" + div;
        else s1 += div;
        
        if (rem < 10) s2 += "0" + rem;
        else s2 += rem;
        
        return s1 + ":" + s2;
    }
}