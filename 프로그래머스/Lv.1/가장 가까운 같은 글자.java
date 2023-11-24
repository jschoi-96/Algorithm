import java.util.*;
class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int [] answer = new int[len];
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < len; i++){
            char target = s.charAt(i);
            if (!map.containsKey(target)){
                map.put(target, i); // 처음 등장할 때 맵에는 인덱스 값을 넣어줌.
                answer[i] = -1; // 배열은 -1로 초기화 해줌.
            }
            
            else { // 등장한 적이 있는 문자열일 때
                answer[i] = i - map.get(target); 
                map.put(target, i);
            }
        }
        return answer;
    }
}
