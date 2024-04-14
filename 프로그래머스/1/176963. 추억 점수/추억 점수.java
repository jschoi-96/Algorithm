import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        // 맵에 이름에 해당하는 추억 점수를 저장
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for(String [] arr : photo) {
            int sum = 0;
            for(String key : arr) {
                sum += map.getOrDefault(key , 0);
            }
            answer[idx++] = sum;
        }
        return answer;
    }
}