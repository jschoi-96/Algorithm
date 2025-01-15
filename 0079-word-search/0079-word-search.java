class Solution {
    boolean flag = false;
    boolean [][] visited; 
    int n, m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) { // 첫글자가 같아야 탐색 시작.
                    visited[i][j] = true;
                    dfs(board, word, i, j, 0, "");
                    visited[i][j] = false;
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, String word, int i, int j, int len, String cur) {
        cur += board[i][j];
        
        if (len == word.length() - 1) {
            if (cur.equals(word)) {
                flag = true;
                return;
            }
            return;
        }

        if (i - 1 >= 0 && !visited[i-1][j]) {
            visited[i-1][j] = true;
            dfs(board, word, i-1, j, len + 1, cur);
            visited[i-1][j] = false;
        }
        if (i + 1 < n && !visited[i+1][j]) {
            visited[i+1][j] = true;
            dfs(board, word, i+1, j, len + 1, cur);
            visited[i+1][j] = false;
        }
        if (j - 1 >= 0 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            dfs(board, word, i, j-1, len + 1, cur);
            visited[i][j-1] = false;
        }
        if (j + 1 < m && !visited[i][j+1]) {
            visited[i][j+1] = true;
            dfs(board, word, i, j+1, len + 1, cur);
            visited[i][j+1] = false;
        }
            
    }
}