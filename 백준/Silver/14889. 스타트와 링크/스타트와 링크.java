import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[][] board;
    static int n;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        arr = new int[n/2];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(1, 1);
        System.out.println(min);
    }

    public static void dfs(int depth, int nxt) {
        if (depth == n/2) {

            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if (visited[i]) start.add(i);
                else link.add(i);
            }
            int start_score = getScore(start);
            int link_score = getScore(link);

//            for (int i = 0; i < start.size(); i++) {
//                System.out.print(start.get(i) + " ");
//            }
//            System.out.println();
//
//            for(int j = 0; j < link.size(); j++) {
//                System.out.print(link.get(j) + " ");
//            }
//            System.out.println();
//            System.out.println(start_score + " " + link_score);
            min = Math.min(min, Math.abs(start_score - link_score));
            return;
        }

        for(int i = nxt; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static int getScore(List<Integer> list) {
        int score = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                int a = list.get(i);
                int b = list.get(j);
                score += board[a][b] + board[b][a];
            }
        }
        return score;
    }
}
