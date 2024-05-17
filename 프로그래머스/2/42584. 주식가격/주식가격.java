import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 1. 다음 값이 현재 값보다 작을 때 
        // 2. 다음 값이 현재 값보다 클 때 -> 
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            
            while (!s.isEmpty() && prices[i] < prices[s.peek()]) { // 다음 값이 현재 값보다 작다면, 
                answer[s.peek()] = i - s.peek(); 
                s.pop(); // 제거
            }
            
           
            s.push(i);
        }
        
        while(!s.isEmpty())  {
            int cur = s.peek();
            //System.out.println(cur);
            answer[cur] = prices.length - cur - 1;
            s.pop();
              
        }
        return answer;
    }
}