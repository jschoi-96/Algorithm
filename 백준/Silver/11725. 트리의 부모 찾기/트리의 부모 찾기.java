import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        parent = new int[n+1];
        for(int i = 0; i < n -1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        bfs(1);

        for(int i = 2; i < parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph.get(node)){
                if (visited[next]) continue;
                queue.add(next);
                visited[next] = true;
                parent[next] = node;
            }
        }
    }
}