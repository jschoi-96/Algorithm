import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n, a, b, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    static int res = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) { // 초기화
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(a, b, 0);
        System.out.println(res);
    }

    public static void dfs(int start, int end, int depth) {
        visited[start] = true;
        if (start == end) {
            res = depth;
            return;
        }

        for(int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next, end, depth + 1);
            }
        }
    }

}