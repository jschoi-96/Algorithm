import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        price = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n+1];
        int total = 0;
        for(int i = 1; i <= n; i++) {

            if (!visited[i])
                total += bfs(i, visited);
        }

        if (total > k) System.out.println("Oh no");
        else System.out.println(total);
    }

    public static int bfs(int start, boolean[] visited) {
        visited[start] = true;
        int cost = price[start];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cost = Math.min(cost, price[next]);
                }
            }
        }

        return cost;
    }
}
