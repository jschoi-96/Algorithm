import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] res;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int b = Integer.parseInt(st.nextToken());
                if (b == 1) {
                    graph.get(i+1).add(j+1);
                }
            }
        }

        res = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            bfs(i, visited);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int start, boolean[] visited) {
        //visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if (visited[i]) res[start][i] = 1;
        }
    }
}