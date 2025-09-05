import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int node;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) root = i;
            else graph.get(parent).add(i);
        }

        node = Integer.parseInt(br.readLine());
        if (node == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(res);
    }

    public static void dfs(int root) {
        visited[root] = true;
        int childs = 0;
        for(int next: graph.get(root)) {
            if (!visited[next] && next != node) {
                childs++;
                dfs(next);
            }
        }

        if (childs == 0) res++;
    }
}
