import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
        return a[1] - b[1];
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= n; i++) {
            bfs(i);
        }

        int min = 50;
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty() && min >= pq.peek()[1]) {
            int[] p = pq.poll();
            min = p[1];
            ans.add(p[0]);
        }
        Collections.sort(ans);
        System.out.println(min + " " + ans.size());
        for(Integer i : ans) System.out.print(i + " ");
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        int max = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];

            max = Math.max(dist, max);
            for(int next : graph.get(node)) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new int[]{next, dist + 1});
            }
        }

        pq.add(new int[]{start, max});
    }
}
