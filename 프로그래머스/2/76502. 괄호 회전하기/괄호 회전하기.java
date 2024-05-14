import java.util.Stack;
class Solution {
    // s/2 길ㅇ
    static int answer = 0;
    public int solution(String s) {
        
        for(int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0,i);
            check(tmp);
        }
        return answer;
    }
    
    public void check(String tmp) {
        Stack<Character> stack = new Stack<>();
        for(char c : tmp.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
                
                else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                }
                
                else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                    continue;
                }
            }
            
            stack.add(c);
        }
        if (stack.isEmpty()) answer++;
    }
}