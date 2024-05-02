import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String [] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        for(String st : str) sb.append(st);
        return sb.toString();
    }
}