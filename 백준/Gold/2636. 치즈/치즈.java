import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
        공기랑 접촉한 칸 판독 여부 -> 인접 칸이 하나라도 0인경우에 가장자리
     */
    static int r, c;
    static int[][] board = new int[102][102];
    static int[][] side = new int[102][102];
    static int cheeseCnt = 0;
    static int time = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) cheeseCnt++;
            }
        }

        int cheese_res = 0;
        while(cheeseCnt > 0) {
            boolean [][] visited = new boolean[102][102];
            cheese_res = cheeseCnt;
            bfs(visited);
            time++;
        }

        System.out.println(time - 1);
        System.out.println(cheese_res);

    }

    public static void bfs(boolean[][] visited) {
        cheeseCnt = 0;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (board[nx][ny] == 0) { // 0일떄 다시 bfs 탐색
                    q.add(new int[]{nx, ny});
                }
                else { // 1이라면 0으로 바꿔줘서 겉 부분을 녹여 없앤다.
                    cheeseCnt++;
                    board[nx][ny] = 0;
                }
            }
        }
    }
}
