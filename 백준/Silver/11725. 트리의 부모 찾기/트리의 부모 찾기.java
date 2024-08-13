import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int [] parent;
    static boolean [] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
//        for(int i = 2; i <= n; i++){
//            sb.append(graph.get(i).get(0)).append("\n");
//        }

        for(int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int start) {
        visited[start] = true;
        for(int nxt : graph.get(start)) {
            if (!visited[nxt]) {
                // System.out.println("start: " + start + " nxt: " + nxt);
                parent[nxt] = start;
                dfs(nxt);
            }
        }
    }
}
