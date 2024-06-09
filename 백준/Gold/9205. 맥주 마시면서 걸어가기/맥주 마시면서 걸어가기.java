import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int t, n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int k = 0; k < t; k++) {
            n = Integer.parseInt(br.readLine());

            List<int[]> location = new ArrayList<>();
            boolean [] visited = new boolean[n + 2];
            List<List<Integer>> graph = new ArrayList<>();

            for(int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                location.add(new int[]{x, y});
            }


            for(int i = 0; i < n + 2; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < n + 2; i++){
                for(int j = i + 1; j < n + 2; j++) {
                    if (possible(location.get(i), location.get(j))) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            if (bfs(graph, visited)) sb.append("happy");
            else sb.append("sad");

            if (k < t - 1) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean bfs(List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int next : graph.get(node)) {
                if (visited[next]) continue;

                if (next == n + 1) return true; // 간선의 개수가 n + 1개, 즉 끝점에 도달했다는 뜻
                visited[next] = true;
                queue.add(next);
            }
        }
        return false;
    }

    public static boolean possible(int [] x, int [] y) {
        if ((Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1])) <= 1000) return true;
        return false;
    }
}