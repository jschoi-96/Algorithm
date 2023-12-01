import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for(String s : completion){
            map.put(s, map.getOrDefault(s, 0) - 1);
        }
        
        for(String s : map.keySet()){
            if (map.get(s) > 0) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
