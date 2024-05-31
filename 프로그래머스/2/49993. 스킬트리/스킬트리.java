import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            int idx = 0;
            boolean flag = true;
            
            for(char c : tree.toCharArray()) {
                int check = skill.indexOf(c);
                
                if (check != -1) {    
                    if (skill.charAt(idx) == c) {
                        idx++;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) answer++;
        }
        
        return answer;
    }
}