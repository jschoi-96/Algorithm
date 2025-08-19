import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        Queue<Pos> q = new LinkedList<>();
        boolean[] visited = new boolean[102];
        q.add(new Pos(1, 0));
        visited[1] = true;

        while(!q.isEmpty()) {
            Pos p = q.poll();
            int cur = p.pos;
            int cnt = p.cnt;

            if (cur == 100) {
                System.out.println(cnt);
                return;
            }

            for(int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100 || visited[next]) continue;

                if (map.containsKey(next)) next = map.get(next);

                visited[next] = true;
                q.add(new Pos(next, cnt + 1));
            }
        }
    }

    public static class Pos {
        public int pos;
        public int cnt;
        public Pos(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
