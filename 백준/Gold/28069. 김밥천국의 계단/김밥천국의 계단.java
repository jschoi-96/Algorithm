import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        boolean[] visited = new boolean[2*n + 1];
        visited[0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int pos = cur.pos;
            int cnt = cur.cnt;

            if (pos == n) {
                if (cnt > k) {
                    System.out.println("water");
                } else {
                    System.out.println("minigimbob");
                }
                return;
            }

            int next = pos + 1;
            if (next < 2*n && !visited[next]) {
                visited[next] = true;
                q.add(new Node(next, cnt + 1));
            }

            next = pos + pos/2;
            if (next < 2*n && !visited[next]) {
                visited[next] = true;
                q.add(new Node(next, cnt + 1));
            }
        }
    }

    public static class Node {
        int pos;
        int cnt;
        public Node(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
