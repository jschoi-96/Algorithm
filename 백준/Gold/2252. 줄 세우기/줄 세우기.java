import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int [] deg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }
        deg = new int[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            deg[v]++;
        }

        Queue<Integer> q = new LinkedList<>(); // degree가 0인 정점을 먼저 queue에 넣는다.

        for(int i = 1; i <= n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.println(cur);
            for(int nxt : graph.get(cur)) {
                deg[nxt]--;
                if (deg[nxt] == 0) q.add(nxt);
                // System.out.println("nxt: " + nxt);
            }
        }
    }
}