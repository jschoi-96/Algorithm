import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int [][] board;
    static boolean [] visited;
    static int min = Integer.MAX_VALUE;
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

        // 재귀 종료 조건?
        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int idx, int depth) {
        if (depth == n / 2) {
            calc();
            return;
        }

        for(int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void calc() {
        int start = 0;
        int link = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) { // 두 곳을 모두 방문
                    start += board[i][j];
                    start += board[j][i];
                }

                else if (!visited[i] && !visited[j]) {
                    link += board[i][j];
                    link += board[j][i];
                }
            }
        }
        int res = Math.abs(start - link);
        min = Math.min(res , min);
    }
}