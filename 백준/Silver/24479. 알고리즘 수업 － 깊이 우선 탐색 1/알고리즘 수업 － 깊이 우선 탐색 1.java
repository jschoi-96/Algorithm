import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    static int [] arr = new int[100002];
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(r);

        for(int i = 1; i <= n; i++) {
            if (arr[i] != 0)
                System.out.println(arr[i]);
            else {
                System.out.println(0);
            }
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        arr[start] = cnt++;
        Collections.sort(graph.get(start));
        for(int nxt : graph.get(start)) {
            if (!visited[nxt]) {
                dfs(nxt);
            }
        }
    }
}
