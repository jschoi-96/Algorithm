import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
                
            }
            stack.push(c);
        }
        
        if (stack.empty()) return true;
        return false;
    }
}