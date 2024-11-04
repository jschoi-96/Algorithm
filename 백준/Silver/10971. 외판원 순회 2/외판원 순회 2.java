import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] board;
    static boolean [] visited;
    static int n;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 1, 0);
        System.out.println(res);
    }

    public static void dfs(int start, int cur, int depth , int sum) {
        visited[start] = true;

        if (depth == n) {
            //System.out.println(sum + board[cur][start]);
            if (board[cur][start] != 0) { // 돌아가는 지점이 0일때는 고려하지 않는다. (못감) 
                res = Math.min(res, sum + board[cur][start]);
            }
            return;
        }


        for(int i = 0; i < n; i++) {
            if (!visited[i] && board[cur][i] != 0) {
                visited[i] = true;
                dfs(start, i, depth + 1, sum + board[cur][i]);
                visited[i] = false;
            }
        }
    }
}
