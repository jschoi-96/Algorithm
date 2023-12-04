import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        List<Integer> temp = new ArrayList<>();
        
            
        String [] nums = s.split(" ");
        for(String num : nums) {
            temp.add(Integer.parseInt(num));
        } 
            
        int min = Collections.min(temp);    
        int max = Collections.max(temp);
        answer.append(min).append(" ").append(max);
        
       
        return answer.toString();
    }
}
