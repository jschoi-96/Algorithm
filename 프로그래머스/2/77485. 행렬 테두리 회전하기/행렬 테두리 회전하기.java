class Solution {
    static int[][] board;
    static int idx = 0;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        board = new int[rows][columns];
        int idx = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                board[i][j] = idx++;
            }
        }
        
        for(int [] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            rotate(x1,y1,x2,y2, answer);
        }
        return answer;
    }
    
    public void rotate(int x1, int y1, int x2, int y2, int[] answer) {
        int tmp = board[x1][y1];
        int min = tmp;
        
        for(int i = x1; i < x2; i++) { // 왼쪽 아래 -> 위
            board[i][y1] = board[i+1][y1];   
            min = Math.min(min, board[i][y1]);
            //System.out.print(board[i][y1] + " ");
        }
        //System.out.println();
        
        for(int i = y1; i < y2; i++) { // 밑 오른 -> 왼
            board[x2][i] = board[x2][i+1];
            min = Math.min(board[x2][i], min);
            //System.out.print(board[x2][i] + " ");
        }
        //System.out.println();
        
        for(int i = x2; i > x1; i--) { // 오른쪽 위 -> 아래 
            board[i][y2] = board[i-1][y2];
            min = Math.min(min, board[i][y2]);
            //System.out.print(board[i][y2] + " ");
        }
        //System.out.println();
        for(int i = y2; i > y1; i--) {
            board[x1][i] = board[x1][i - 1];
            min = Math.min(min, board[x1][i]);
            //System.out.print(board[x1][i] + " ");
        }
        //System.out.println();
        
        
        // for(int i = 0; i < board.length; i++) {
        //     for(int j = 0; j < board[0].length; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        board[x1][y1 + 1] = tmp;
        min = Math.min(min, tmp);
        answer[idx++] = min;
    }
}