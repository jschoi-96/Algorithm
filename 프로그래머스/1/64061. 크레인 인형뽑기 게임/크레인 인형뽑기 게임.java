import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int n = board.length;
        
        Stack<Integer> s = new Stack<>();
        for(int move : moves) {
            int idx = move - 1; // index가 크레인-1이기 때문ㅇ
            
            for(int i = 0; i < n; i++) {
                if (board[i][idx] != 0) {
                    if (!s.isEmpty() && s.peek() == board[i][idx]) {
                        answer += 2;
                        s.pop();
                    }
                    
                    else s.add(board[i][idx]);
                    
                    board[i][idx] = 0; // 뽑았다면 초기화를 시켜줘야함. 
                    
                    break; // 다 마무리 되었다면 더 순회하지 않도록 처리
                }
            }
        }
        
        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }
        
        return answer;
    }
}