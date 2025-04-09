import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> list = new ArrayList<>();
        
        if (cacheSize == 0) return 5 * cities.length;
        
        int time = 0;
        for(String city : cities) {
            String c = city.toLowerCase(); // 대소문자 구분 x
            
            if (!list.contains(c)) { // cache miss인 경우
                time += 5;
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(c);
                continue;
            }
            
            if (list.contains(c)) {
                list.remove(c);
                list.add(c); // 이 과정을 통해 위치를 새롭게 해야힘 
                time++;
            }
        }
        return time;
    }
}