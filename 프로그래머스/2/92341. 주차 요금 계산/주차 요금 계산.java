import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<Integer, Integer> inMap = new HashMap<>(); // 차번호, 입차시간 저장하는 맵
        
        Map<Integer, Integer> sumMap = new HashMap<>(); // 차번호, 누적시간 저장하는 맵.
        for(String record : records) {
            String [] str = record.split(" ");
            int time = cal(str[0]);
            int car = Integer.parseInt(str[1]);
            String command = str[2];
            
            if (command.equals("IN")) { // 입차인 경우에 맵에 값을 넣어줌.
                inMap.put(car, time);
            }
            
            else if (command.equals("OUT")) {
                int prev = inMap.get(car);
                int val = time - prev; // 출차 시간에서 입차시간을 빼서 누적 시간에 넣어준다.
                sumMap.put(car, sumMap.getOrDefault(car, 0) + val);
                
                inMap.put(car, -1); // 이 때, 입차시간은 초기화 시켜줘야한다!!
            }
            // System.out.println(time + " " + car + " " + command);
        }
        
        // 입차시간을 저장한 맵을 순회하며 0으로 초기화가 되지 않은 값을 찾는다.
        // 이 경우에는, 23:59분에서 마지막 입차시간을 빼서 다시 누적시간 맵에 갱신해준다.
        
        for(Integer key : inMap.keySet()) {
            int val = inMap.get(key);
            if (val != -1) {
                int last = cal("23:59");
                last -= val;
                sumMap.put(key, sumMap.getOrDefault(key, 0) + last);
            }
        }
        
        // 누적시간을 저장한 맵에서 차량번호를 오름차순으로 정렬한다.
        List<Integer> list = new ArrayList<>(sumMap.keySet());
        Collections.sort(list);
        
        
        int[] answer = new int[list.size()];
        int idx = 0;

        for(Integer car : list) {
            int t = sumMap.get(car);
            // System.out.println(car + " " + t + " " + calFee(fees, t));    
            
            int result = calFee(fees, t);
            answer[idx++] = result;

        }
        
        return answer;
    }
    
    public int cal(String time) {
        String [] t = time.split(":");
        // 60분 = 1시간
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public int calFee(int[] fees, int t) {
        // 기본 시간 이하일 때 기본요금 청구
        if (t <= fees[0]) return fees[1];
        else {
            int time = t - fees[0];
            int diff = time / fees[2];
            if (time % fees[2] != 0) diff += 1; // 나눠떨어지지 않는 경우에 1더해서 올려줌(?)
            
            return fees[1] + diff * fees[3];
        }
    }
}