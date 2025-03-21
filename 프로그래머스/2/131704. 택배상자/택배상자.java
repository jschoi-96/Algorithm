import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int num = 1;
        
        for(int i = 0; i < order.length; i++) {
            while(num <= order[i]) {
                s.add(num++);
            }
            
            if (!s.isEmpty() && order[i] == s.peek()) {
                s.pop();
                answer++;
            }
            else break;
        }
        return answer;
    }
}