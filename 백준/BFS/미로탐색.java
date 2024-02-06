import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    인접한 dist 값이 0일때에 대해서만 bfs 수행해야한다. 안그러면 탐색을 계속 함
 */
public class 미로탐색 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] board = new int[102][102];
        int [][] dist = new int[102][102];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = input.charAt(j) - '0';
                //System.out.print(board[i][j] + " ");
            }
        }

        queue.add(new int[]{0, 0});
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0 || dist[nx][ny] != 0) continue;

                dist[nx][ny] = dist[x][y] + 1; // 거리 업데이트
                queue.add(new int[]{nx, ny});
            }
        }

        System.out.println(dist[n-1][m-1]);
    }
}
