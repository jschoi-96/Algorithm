import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, List<String>> map = new HashMap<>();
        
        for (String [] cloth : clothes) {
            map.put(cloth[1], new ArrayList<>());
        }
        
        for(String [] cloth : clothes) {
            map.get(cloth[1]).add(cloth[0]);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        
        int res = 1; 
        for(String key : list) {
            List<String> cloth = map.get(key);
            res *= (cloth.size() + 1);
        }
        
        
        return res - 1;
       
    }
}