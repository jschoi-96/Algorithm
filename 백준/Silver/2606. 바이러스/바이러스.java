import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
            visited[i] = true;

            while(!queue.isEmpty()) {
                int node = queue.poll();
                for(int next : graph.get(node)) {
                    if (visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
                cnt++;
            }

            System.out.println(cnt - 1);
            return;
        }
    }
}