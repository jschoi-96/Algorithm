import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();
        
        // 1. targets를 순회하며 해당 알파벳에 맞는 keymap을 찾음
        // 2. keymap이 여러개일 때, min값을 리턴해줌
        
        // 어떻게 하면 keymap이 여러개인데 각각 index를 리턴해주나? 
        
        for(String target : targets) {
            int len = target.length();
            
            int sum = 0;
            int answer_idx = 0;
            for(int i = 0; i < len; i++){
                Character target_val = target.charAt(i);
                int result = getMinIndex(keymap, target_val);
                if (result == -1) {
                    sum = -1;
                    break;
                }
                
                sum += result;
            }
            answer.add(sum);
        }
        
        int [] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
    
    public int getMinIndex(String[] keymap, Character target) {
        int minIndex = Integer.MAX_VALUE;
        for (String key : keymap) {
            int index = key.indexOf(target); // indexOf (특정 문자 위치 찾기)
            if (index != -1 && index < minIndex) {
                minIndex = index;
            }
            
        }
        if (minIndex == Integer.MAX_VALUE) return -1;
        return minIndex + 1;
    }
}
