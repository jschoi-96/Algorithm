import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxHeight = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Integer.max(maxHeight, board[i][j]);
            }
        }

        int res = 0;
        for(int i = 0; i <= maxHeight; i++){
            int num = bfs(board, i);
            res = Integer.max(res, num);
        }
        System.out.println(res);
    }

    // 입력값을 받고, 안전 영역의 최대 개수를 계산하는 메서드
    static int bfs(int[][] board, int n) {
        int[][] rain = new int[102][102];
        boolean[][] visited = new boolean[102][102];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] > n) {
                    rain[i][j] = 1; // 잠기지 않은 지역은 1, 잠기는 지역은 0
                }
            }
        }

        int num = 0;
        for(int i = 0; i < rain.length; i++){
            for(int j = 0; j < rain[0].length; j++){
                if (rain[i][j] == 1 && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for(int dir = 0; dir < 4; dir++){
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= rain.length || ny >= rain[0].length) continue;
                            if (rain[nx][ny] == 0 || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    num++;
                }
            }
        }
        return num;
    }
}
