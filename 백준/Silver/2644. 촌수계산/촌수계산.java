import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, x, y, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    static int res = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
            graph.get(a).add(b);
        }

        dfs(x, y, 0);
        System.out.println(res);
    }

    public static void dfs(int start, int end, int depth) {
        if (start == end) {
            res = depth;
            return;
        }

        for(int nxt : graph.get(start)) {
            if (visited[nxt]) continue;
            visited[nxt] = true;
            dfs(nxt, end, depth + 1);
        }
    }
}
