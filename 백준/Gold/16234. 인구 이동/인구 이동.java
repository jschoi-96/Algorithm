import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, l, r;
    static int day = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            boolean[][] visited = new boolean[n][n];

            boolean flag = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (!visited[i][j] && isPossible(i,j)) {
                        flag = true;
                        bfs(i,j, visited);
                    }
                }
            }

            if (!flag) break;
            day++; // 인구 이동이 불가능한 경우 day를 더하지않고 바로 break처리
        }
        System.out.println(day);
    }

    public static void bfs(int a, int b, boolean[][] visited) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {a,b});
        visited[a][b] = true;
        List<int []> list = new ArrayList<>();
        list.add(new int[]{a, b});

        int sum = board[a][b]; // 인구의 총합을 저장하는 변수
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || Math.abs(board[nx][ny] - board[x][y]) < l || Math.abs(board[nx][ny] - board[x][y]) > r) continue;
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
                sum += board[nx][ny];
                list.add(new int[]{nx, ny});
            }
        }

        if (list.size() > 1) {
            int each = sum / list.size();
            for(int [] pos: list) {
                board[pos[0]][pos[1]] = each;
            }
        }
    }


    public static boolean isPossible(int x, int y) {
        if (x - 1 >= 0 && Math.abs(board[x][y] - board[x-1][y]) >= l && Math.abs(board[x][y] - board[x-1][y]) <= r) return true;
        if (x + 1 < n && Math.abs(board[x][y] - board[x+1][y]) >= l && Math.abs(board[x][y] - board[x+1][y]) <= r) return true;
        if (y - 1 >= 0 && Math.abs(board[x][y] - board[x][y-1]) >= l && Math.abs(board[x][y] - board[x][y-1]) <= r) return true;
        if (y + 1 < n && Math.abs(board[x][y] - board[x][y+1]) >= l && Math.abs(board[x][y] - board[x][y+1]) <= r) return true;
        return false;
    }
}
