import java.util.*;
class Solution {
    public int solution(String before, String after) {
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        for(int i = 0; i < before.length(); i++){
            m1.put(before.charAt(i), m1.getOrDefault(before.charAt(i), 0) + 1);
            m2.put(after.charAt(i), m2.getOrDefault(after.charAt(i) , 0) + 1);
        }
        
        for(char c : m1.keySet()) {
            if (m1.get(c) != m2.get(c)) return 0;
        }
        return 1;
    }
}