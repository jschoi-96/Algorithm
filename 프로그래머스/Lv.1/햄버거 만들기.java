import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(Integer num : ingredient) {
            stack.add(num);
            int size = stack.size();
            if (size >= 4) {
                if (stack.get(size-4) == 1 && stack.get(size-3) == 2 &&
                   stack.get(size-2) == 3 && stack.get(size-1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        
        return answer;
    }
}
