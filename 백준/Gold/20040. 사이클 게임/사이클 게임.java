import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        parent = new int[n+1];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 100만
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (find(u) == find(v)) {
                System.out.println(i + 1);
                return;
            }
            else union(u, v);
        }
        System.out.println(0);
    }

    public static int find(int k) {
        if (parent[k] != k) {
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) parent[y] = x;
    }
}
