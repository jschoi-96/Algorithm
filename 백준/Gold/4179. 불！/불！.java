import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};

    // J가 큐의 시작점 (입력에서 하나만 주어짐)
    // 이동한 지점의 시간 값이 불이 이동한 시간보다 같거나 크다면, IMPOSSIBLE.
    // 두개의 time 배열을 만들어서 시간 비교를 해야함.
    // 탈출했을 때는,
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String [][] board = new String[r][c];
        int [][] ji = new int[r][c];
        int [][] fire = new int[r][c];
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        for(int i = 0; i < r; i++){
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = String.valueOf(input.charAt(j));
                ji[i][j] = -1; fire[i][j] = -1;
                if (board[i][j].equals("J")) {
                    ji[i][j] = 0;
                    queue1.add(new int[]{i, j});
                }
                else if (board[i][j].equals("F")) {
                    fire[i][j] = 0;
                    queue2.add(new int[]{i, j});
                }
            }
        }

        // 불이 이동하는 시간
        while(!queue2.isEmpty()) {
            int [] cur = queue2.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny].equals("#") || fire[nx][ny] >= 0) continue;
                fire[nx][ny] = fire[x][y] + 1;
                queue2.add(new int[]{nx, ny});
            }
        }

        // 지훈이가 이동하는 시간
        while (!queue1.isEmpty()) {
            int[] cur = queue1.poll();
            int x = cur[0];
            int y = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) { // 범위를 벗어났다면, 탈출에 성공했다는 뜻
                    System.out.println(ji[x][y] + 1);
                    return;
                }
                if (ji[nx][ny] >= 0 || board[nx][ny].equals("#"))
                    continue; // 방문했거나, 벽인 경우
                if (fire[nx][ny] != -1 && fire[nx][ny] <= ji[x][y] + 1)
                    continue; // 불이 먼저 도착하는 경우
                ji[nx][ny] = ji[x][y] + 1;
                queue1.add(new int[] { nx, ny });
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
