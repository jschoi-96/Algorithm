class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int oCnt = cnt(board, 'O');
        int xCnt = cnt(board, 'X');
        
        int oWin = win(board, 'O');
        int xWin = win(board, 'X');
        System.out.println(oWin + " " + xWin);
        
        if (oWin > 0 && oCnt != xCnt + 1) return 0;
        if (xWin > 0 && xCnt != oCnt) return 0;
        if (oWin > 0 && xWin > 0) return 0;
        if (oWin == 0 && xCnt == 0 && oCnt > xCnt + 1) return 0;
        if (xCnt > oCnt) return 0;
        return 1;
    }
    
    public int cnt(String [] board, char target) {
        int res = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == target) res++;
            }
        }
        return res;
    }
    
    public int win(String [] board, char target) {
        int cnt = 0;
        for(int i = 0; i < board.length; i++) {
            boolean flag = true;
            for(int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) != target) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        
        for(int j = 0; j < board[0].length(); j++) {
            boolean flag = true;
            for(int i = 0; i < board.length; i++) {
                if (board[i].charAt(j) != target) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        
        // 대각선 
        boolean flag = true;
        for(int i = 0; i < board.length; i++) {
            if(board[i].charAt(i) != target) {
                flag = false;
                break;
            }
        }
        if (flag) cnt++;
        
        flag = true;
        for(int i = 0; i < board.length; i++) {
            if (board[i].charAt(board.length - 1 - i) != target) {
                flag = false;
                break;
            }
        }
        if (flag) cnt++;

        return cnt;
    }
}