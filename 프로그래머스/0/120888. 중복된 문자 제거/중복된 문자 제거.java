import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        for(char c : my_string.toCharArray()) {
            set.add(c);
        }
        
        List<Character> list = new ArrayList<>(set);
        for(char c : list) answer += String.valueOf(c);
        return answer;
    }
}