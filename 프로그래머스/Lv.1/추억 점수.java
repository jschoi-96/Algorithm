import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int [] answer = new int[photo.length];
        
        Map<String, Integer> photoMap = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            photoMap.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++){
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                
                // get에서 null 발생, getOrDefault로 null일때 0으로 치환 가능.
                sum += photoMap.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}
