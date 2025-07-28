import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] subTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        subTree = new int[n+1];

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(r, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(subTree[u]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int parent) {
        subTree[start] = 1;
        for(int next : graph.get(start)) {
            if (next == parent) continue;
            dfs(next, start);
            subTree[start] += subTree[next];
        }
    }
}
