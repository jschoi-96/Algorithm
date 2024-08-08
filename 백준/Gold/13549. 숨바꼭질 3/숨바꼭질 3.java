import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {2, -1, 1};
    static int[] dy = {0, 1, 1};

    static int[] dist = new int[200002];
    static boolean[] visited = new boolean[200002];
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dist[n] = 0;
        visited[n] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int dir = 0; dir < 3; dir++) {
                int nx = cur + dx[dir];
                if (dir == 0) nx = cur * 2;

                if (nx < 0 || nx >= 200000) continue;
                if (visited[nx]) continue;
                dist[nx] = dist[cur] + dy[dir];
                visited[nx] = true;
                q.add(nx);
            }
        }

        System.out.println(dist[k]);
    }
}
