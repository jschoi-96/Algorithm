import java.util.*;
class Solution
{
    public int solution(String s)
    {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char target = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
            }
            
            else {
                stack.push(target);
            }
        }
        if (stack.isEmpty()) return 1;
        else return 0;

    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12909 올바른 괄호랑 똑같은 문제
