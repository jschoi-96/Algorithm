import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static boolean[] visited;
    static long res = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];
        visited = new boolean[22];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 2; i <= n / 2; i++) {
            backtrack(1, 0, i);
        }
        System.out.println(res);
    }

    public static void backtrack(int start, int cnt, int limit) {
        if (cnt == limit) {
            res = Math.min(res, diff());
            return;
        }

        for(int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, cnt + 1, limit);
                visited[i] = false;
            }
        }
    }

    public static long diff() {
        List<Integer> start = new ArrayList<>();
        List<Integer> link = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if (visited[i]) start.add(i);
            else link.add(i);
        }

        long start_sum = 0;
        for(int i = 0; i < start.size(); i++) {
            for(int j = i + 1; j < start.size(); j++) {
                int x = start.get(i);
                int y = start.get(j);
                start_sum += board[x][y] + board[y][x];
            }
        }

        long link_sum = 0;
        for(int i = 0; i < link.size(); i++) {
            for(int j = i + 1; j < link.size(); j++) {
                int x = link.get(i);
                int y = link.get(j);
                link_sum += board[x][y] + board[y][x];
            }
        }
        return Math.abs(start_sum - link_sum);
    }
}
