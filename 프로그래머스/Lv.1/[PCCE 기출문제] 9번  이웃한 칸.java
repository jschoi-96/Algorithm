접근 방법
1. BFS 쉬운 버전인 문제, 풀이 방법대로 따라가면 쉽게 풀린다

String을 비교할 때는 == 이 아닌 equals로 비교하자!! 

class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int n = board.length; 
        int count = 0;
        int [] dh = {0,1,-1,0};
        int [] dw = {1,0,0,-1};
        
        for(int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if (h_check < 0 || h_check >= n || w_check < 0 || w_check >= n) continue;
            if (board[h][w].equals(board[h_check][w_check])) {
                count++;
            }
        }
        return count;
    }
}
