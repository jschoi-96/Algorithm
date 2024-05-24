import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int [][] board;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0, 1, 0, -1};
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int[] res;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        res = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) home.add(new int[]{i,j});
                else if (board[i][j] == 2) chicken.add(new int[]{i,j});
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            calculate();
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            res[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    private static void calculate() {
        int total = 0;
        for (int[] h : home) {

            int min_dist = Integer.MAX_VALUE;
            for (int idx : res) {
                int [] c = chicken.get(idx);
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                min_dist = Math.min(min_dist, dist);
            }
            total += min_dist;
        }
        answer = Math.min(answer, total);
    }
}