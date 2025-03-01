import java.util.*;
class Solution {
    // 기본시간 미만일 떄 -> 기본요금
    // 넘을 때 -> 기본요금 + (누적 - 기본시간) / 단위 시간 * 단위 요금
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> map = new HashMap<>(); // [차번호, 마지막 입차시간]
        Map<String, Integer> timeMap = new HashMap<>(); // [차번호, 누적시간]
        
        for(String record : records) {
            String [] arr = record.split(" ");
            String time = arr[0];
            String carNum = arr[1];
            String command = arr[2];
            
            String [] timeSplit = arr[0].split(":");
            String hour = timeSplit[0];
            String min = timeSplit[1];
            
            int totalTime = Integer.parseInt(hour) * 60 + Integer.parseInt(min);
            //System.out.println(totalTime);
            if (command.equals("IN")) {
                map.put(carNum, totalTime); // 현재 입차시간 저장
            }
            
            else {
                int inTime = map.get(carNum); // 기존 입차시간
                int sum = totalTime - inTime;
                map.put(carNum, -1); // 입차시간을 초기화

                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + sum); // 누적시간을 저장 
            }
        }
        
        int lastTime = 23 * 60 + 59;
        for(String key : map.keySet()) {
            if (map.get(key) != -1) { // 여기서 0이 아니란 뜻은 출차 기록이 없다는 뜻. 따라서 마지막 시간에서 빼서 더해줌
                timeMap.put(key, timeMap.getOrDefault(key, 0) + lastTime - map.get(key));
            }
        }
        
        int default_time = fees[0];
        int default_price = fees[1];
        int unit_time = fees[2];
        int unit_price = fees[3];
        
        int[] answer = new int[map.size()];
        int idx = 0;
        
        List<String> cars = new ArrayList<>(timeMap.keySet());
        Collections.sort(cars);
        
        for (String time : cars) {
            int sum = timeMap.get(time);
            if (sum <= default_time) {
                // System.out.println(time + " " + default_price);
                answer[idx++] = default_price;
                // System.out.println("idx: " + idx);
            }
            
            else {
                int newTime = (sum - default_time) / unit_time;
                if ((sum - default_time) % unit_time != 0) newTime += 1;
                int newSum = default_price + newTime * unit_price;
                // System.out.println(time + " " + newSum);
                answer[idx++] = newSum;
                // System.out.println("idx: " + idx);
            }
            
            
        }
        

 
        return answer;
    }
}