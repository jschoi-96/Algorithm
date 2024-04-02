import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static char [][][] board;
    static int [][][] dist;
    static boolean [][][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            board = new char[l][r][c];
            dist = new int[l][r][c];
            visited = new boolean[l][r][c];

            int start_x = 0; int start_y = 0; int start_z = 0;
            int end_x = 0; int end_y = 0; int end_z = 0;
            for(int i = 0; i < l; i++) {
                for(int j = 0; j < r; j++) {
                    String temp = br.readLine();
                    for(int k = 0; k < c; k++) {
                        board[i][j][k] = temp.charAt(k);
                        if (board[i][j][k] == 'S') {
                            start_x = i;
                            start_y = j;
                            start_z = k;
                        }

                        if (board[i][j][k] == 'E') {
                            end_x = i;
                            end_y = j;
                            end_z = k;
                        }
                    }
                }
                br.readLine(); // 빈 줄 입력받는거 !!
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start_x, start_y, start_z});
            visited[start_x][start_y][start_z] = true;
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int z = cur[2];
                for(int dir = 0; dir < 6; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    int nz = z + dz[dir];
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c) continue;
                    if (board[nx][ny][nz] == '#' || visited[nx][ny][nz]) continue;
                    dist[nx][ny][nz] = dist[x][y][z] + 1;
                    visited[nx][ny][nz] = true;
                    queue.add(new int[]{nx, ny, nz});
                }
            }
            int result = dist[end_x][end_y][end_z];
            if (result == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }
}