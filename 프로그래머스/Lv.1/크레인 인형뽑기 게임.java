import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 스택을 만들어서 top과 인형을 잡고있는 값을 비교하고, 같으면 삭제한다
        // moves배열에 해당하는 가장 위의 값을 확인.
        Stack<Integer> bags = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            int check = moves[i] - 1; // - 1을 하는 이유는 0부터 시작하기 때문
            
            for(int j = 0; j < board.length; j++) {
                if (board[j][check] != 0) {
                    if (!bags.isEmpty() && bags.peek() == board[j][check]) {
                        answer += 2;
                        bags.pop(); 
                    }
                    
                    else {
                       bags.push(board[j][check]);  
                    }
                    
                    board[j][check] = 0; // 0으로 초기화를 해서 다음에 집지 않도록 해준다.
                    break;
                }
            }
        }
        
        return answer;
    }
}
