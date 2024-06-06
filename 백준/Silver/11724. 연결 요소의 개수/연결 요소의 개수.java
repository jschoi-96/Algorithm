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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
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

        int res = 0;
        for(int i = 1; i <= n; i++){
            if (visited[i]) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int v = queue.poll();
                for(int next : graph.get(v)) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            res++;
        }
        System.out.println(res);
    }
}