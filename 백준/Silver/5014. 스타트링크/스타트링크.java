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

        int f = Integer.parseInt(st.nextToken()); // f층으로 이루어짐
        int s = Integer.parseInt(st.nextToken()); // 강호가 있는곳의 층
        int g = Integer.parseInt(st.nextToken()); // 스타트 링크가 있는 층
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int [] board = new int[1000001];
        boolean[] visited = new boolean[1000001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        int[] dirs = {u, -d};
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int dir = 0; dir < 2; dir++){
                int nx = cur + dirs[dir];
                if (nx < 1 || nx > f) continue;
                if (board[nx] != 0 || visited[nx]) continue;
                board[nx] = board[cur] + 1;
                visited[nx] = true;
                queue.add(nx);
            }
        }

        if (!visited[g]) {
            System.out.println("use the stairs");
            return;
        }
        System.out.println(board[g]);
    }
}