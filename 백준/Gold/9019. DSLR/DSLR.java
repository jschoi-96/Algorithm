import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a, b);
        }
    }

    public static void bfs(int a, int b) {
        boolean[] visited = new boolean[10002];
        visited[a] = true;
        Queue<Pos> q = new LinkedList<>();

        q.add(new Pos(a, 0, new StringBuilder()));

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            int x = cur.cur, dist = cur.dist;
            StringBuilder command = cur.command;

            if (x == b) {
                System.out.println(command);
                return;
            }

            int new_d = 2*x;
            if (new_d > 9999) new_d %= 10000;
            if (!visited[new_d]) {
                visited[new_d] = true;
                StringBuilder next = new StringBuilder(command).append("D");
                q.add(new Pos(new_d, dist + 1, next));
            }

            int new_s = x - 1;
            if (x == 0) new_s = 9999;
            if (!visited[new_s]) {
                visited[new_s] = true;
                StringBuilder next = new StringBuilder(command).append("S");
                q.add(new Pos(new_s, dist + 1, next));
            }

            int new_l = (x % 1000) * 10 + x / 1000;
            if (!visited[new_l]) {
                visited[new_l] = true;
                StringBuilder next = new StringBuilder(command).append("L");
                q.add(new Pos(new_l, dist + 1, next));
            }

            int new_r = (x / 10) + (x % 10) * 1000;
            if (!visited[new_r]) {
                visited[new_r] = true;
                StringBuilder next = new StringBuilder(command).append("R");
                q.add(new Pos(new_r, dist + 1, next));
            }
        }
    }

    public static class Pos {
        int cur;
        int dist;
        StringBuilder command;
        public Pos(int cur, int dist, StringBuilder command) {
            this.cur = cur;
            this.dist = dist;
            this.command = command;
        }
    }
}
