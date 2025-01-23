class Solution {
    boolean flag = false;
    boolean [][] visited; 
    int n, m;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) { // 첫글자가 같아야 탐색 시작.
                    if (dfs(board,word,i,j,0)) {
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j]
        || board[i][j] != word.charAt(idx)) return false;

        visited[i][j] = true;
        for(int dir = 0; dir < 4; dir++) {
            int x = i + dx[dir];
            int y = j + dy[dir];
            if (dfs(board, word,x,y,idx+1)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}