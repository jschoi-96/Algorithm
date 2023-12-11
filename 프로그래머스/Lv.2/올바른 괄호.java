import java.util.*;
class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack();
        
        if (s.length() == 1) return false;
        if (s.length() % 2 != 0) return false; 
        for(int i = 0; i < s.length(); i++){
            char target = s.charAt(i);
                          
            if (target == ')') { 
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            
            else {
                stack.push(target); 
            }
        }
        return stack.isEmpty();
    }
}
