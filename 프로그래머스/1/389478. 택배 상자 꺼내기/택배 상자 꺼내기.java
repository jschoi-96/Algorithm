class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int height = n % w == 0 ? n / w : (n / w) + 1;
        int [][] board = new int[height][w];
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < w; j++) board[i][j] = 0;
        }
        
        boolean flag = true;
        int val = 1;
        
        int [] pos = new int[2];
        for(int i = height - 1; i >= 0; i--) {
            if (flag) {
                for(int j = 0; j < w; j++) {
                    if (val > n) break;
                    board[i][j] = val;
                    if (val == num) {
                        pos[0] = i;
                        pos[1] = j;
                    }
                    val++;
                }
                flag = false;
            }
            
            else {
                for(int j = w - 1; j >= 0; j--) {
                    if (val > n) break;
                    board[i][j] = val;
                    if (val == num) {
                        pos[0] = i;
                        pos[1] = j;
                    }
                    val++;
                }
                flag = true;
            }
        }
        
        for(int i = 0; i <= pos[0]; i++) {
            //System.out.println(board[i][pos[1]]);
            if (board[i][pos[1]] == 0) continue;
            answer++;
        }
        return answer;
    }
}