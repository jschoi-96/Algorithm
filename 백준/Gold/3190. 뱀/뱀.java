import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k, l;
    static int[][] board;
    static boolean[][] visited;
    static Map<Integer, String> dirMap = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        /*
        머리를 다음칸에 위치시킴
        사과 O -> 사과만 삭제, 꼬리는 움직이지 않음
        사과 X -> 꼬리칸을 비워줌
        벽이나 몸에 부딪히면 게임 종료
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a-1][b-1] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            dirMap.put(a, dir);
        }

        // 뱀은 처음에 오른쪽을 향하고, 시작위치는 (0,0)
        visited[0][0] = true;
        int x = 0, y = 0, d = 0, time = 0;
        Deque<Pos> q = new LinkedList<>();
        q.addLast(new Pos(0, 0));

        while (true) {
//            Pos cur = q.poll();
//            int x = cur.x;
//            int y = cur.y;

            int nx = x + dx[d];
            int ny = y + dy[d];
            time++;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) { // 종료 조건
                System.out.println(time);
                break;
            }

            visited[nx][ny] = true; // 다음 칸으로 이동
            q.addLast(new Pos(nx, ny));
            if (board[nx][ny] == 1) { // 다음칸에 사과가 있다면 제거
                board[nx][ny] = 0;
            }

            else { // 사과가 없다면 꼬리 칸을 비워준다.
                Pos cur = q.pollFirst();
                visited[cur.x][cur.y] = false;
            }

            if (dirMap.containsKey(time)) { // 방향 전환
                String dir = dirMap.get(time);
                if (dir.equals("L")) { // 방향 왼쪽
                    d = (d + 3) % 4;
                }

                else { // 오른쪽
                    d = (d + 1) % 4;
                }
            }

            x = nx;
            y = ny;
        }
    }

    public static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
