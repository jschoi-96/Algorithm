import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        // 1. 해쉬맵을 통해 길이가 1인 알파벳 색인 번호를 등록한다
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            map.put(String.valueOf(c), i+1);
        }
        
        int idx = 27;
        int i = 0;
        
        List<Integer> list = new ArrayList<>();
        while(i < msg.length()) {
            String tmp = "";
            int j = i;
            
            while(j < msg.length() && map.containsKey(msg.substring(i, j + 1))) {
                j++; 
            }
                
            tmp = msg.substring(i, j);
            list.add(map.get(tmp)); // 색인번호 추가
            
            if (j < msg.length()) {
                String next = msg.substring(i, j + 1);
                //System.out.println("next: " + next);
                map.put(next, idx++);
            }
            //System.out.println(tmp);
            
            i = j;
        }
        
        int[] answer = new int[list.size()];
        for(int j = 0; j < answer.length; j++) answer[j] = list.get(j);
        
        return answer;
    }
}