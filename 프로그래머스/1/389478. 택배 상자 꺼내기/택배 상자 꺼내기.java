class Solution {
    int idx = 1;
    int nums = 0;
    int target = 0;
    
    int [] pos = new int[2];
    public int solution(int n, int w, int num) {
        int answer = 0;
        nums = n;
        target = num;
        
        // 1.높이 정의
        int h = 0;
        if (n % w != 0) h = n/w + 1;
        else h = n/w; 
        
        int[][] board = new int[h][w];
                        
        int cur = h-1; // 시작 높이 
        
        while (cur >= 0) {
            right(board, cur,w);
            cur -= 1;
            if (cur < 0) break;
            left(board, cur,w);
            cur -= 1;
        }
        
        int x = pos[0]; // 뽑으려는 상자의 높이 좌표
        int y = pos[1];
        
        int cnt = 0;
        for(int i = 0; i <= x; i++) {
            if (board[i][y] == 0) continue;
            cnt++;
        }
        
        return cnt;
    }
    
    public void right(int[][] board, int cur, int w) {
        for(int i = 0; i < w; i++) {
            if (idx > nums) continue;
            board[cur][i] = idx++;
            if (board[cur][i] == target) {
                pos[0] = cur;
                pos[1] = i;
            }
        }
    }
    
    public void left(int[][] board, int cur, int w) {
        for(int i = w - 1; i >= 0; i--) {
            if (idx > nums) continue;
            board[cur][i] = idx++;
            if (board[cur][i] == target) {
                pos[0] = cur;
                pos[1] = i;
            }
        }
    }
}