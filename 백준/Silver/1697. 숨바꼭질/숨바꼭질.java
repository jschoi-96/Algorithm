import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 2};
    static int[] dist = new int[200001];
    static boolean[] visited = new boolean[200001];
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited[n] = true;
        queue.add(n);
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == k) {
                System.out.println(dist[k]);
                return;
            }

            for(int dir = 0; dir < 3; dir++) {
                int nx = cur + dx[dir];
                if (dir == 2) {
                    nx = cur * dx[dir];
                }
                if (nx < 0 || nx >= 200000 || visited[nx]) continue;
                dist[nx] = dist[cur] + 1;
                visited[nx] = true;
                queue.add(nx);
            }
        }
    }
}
