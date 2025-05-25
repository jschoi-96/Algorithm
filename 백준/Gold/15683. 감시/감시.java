import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static List<CCTV> cctvList = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) cctvList.add(new CCTV(1, 4, new int[]{i,j}));
                else if (board[i][j] == 2) cctvList.add(new CCTV(2, 2, new int[]{i,j}));
                else if (board[i][j] == 3) cctvList.add(new CCTV(3, 4, new int[]{i,j}));
                else if (board[i][j] == 4) cctvList.add(new CCTV(4, 4, new int[]{i,j}));
                else if (board[i][j] == 5) cctvList.add(new CCTV(5, 1, new int[]{i,j}));
            }
        }

        dfs(0, board);
        System.out.println(res);
    }

    public static void dfs(int depth, int[][] board) {
        if (depth == cctvList.size()) {
            // printBoard(board);
            res = Math.min(res, calculateArea(board));
            return;
        }

        CCTV cur = cctvList.get(depth);
        for(int i = 0; i < cur.dir; i++) { // cctv의 방향 케이스만큼 순회
            int[][] tmp = copyBoard(board);
            apply(tmp, cur, i);
            dfs(depth + 1, tmp);
        }
    }

    public static void apply(int[][] tmp, CCTV cur, int dir) {
        int type = cur.type;

        if (type == 1) {
            applyBoard(tmp, cur, dir);
        }

        else if (type == 2) {
            applyBoard(tmp, cur, dir);
            applyBoard(tmp, cur, (dir + 2) % 4);
        }

        else if (type == 3) {
            applyBoard(tmp, cur, (dir + 3) % 4);
            applyBoard(tmp, cur, dir);
        }

        else if (type == 4) {
            applyBoard(tmp, cur, (dir + 3) % 4);
            applyBoard(tmp, cur, (dir + 2) % 4);
            applyBoard(tmp, cur, dir);
        }

        else if (type == 5) {
            applyBoard(tmp, cur, (dir + 3) % 4);
            applyBoard(tmp, cur, (dir + 2) % 4);
            applyBoard(tmp, cur, (dir + 1) % 4);
            applyBoard(tmp, cur, dir);
        }
    }

    public static void applyBoard(int[][] tmp, CCTV cur, int dir) {
        int x = cur.pos[0];
        int y = cur.pos[1];

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
            if (tmp[nx][ny] == 6) break;
            if (tmp[nx][ny] == 0) tmp[nx][ny] = -1;
            x = nx;
            y = ny;
        }
    }

    public static int calculateArea(int[][] board) {
        int area = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 0) area++;
            }
        }
        return area;
    }

    public static void printBoard(int[][] tmp) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] copyBoard(int[][] board) {
        int[][] tmp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        return tmp;
    }

    public static class CCTV {
        public int type;
        public int dir;
        public int[] pos;
        public CCTV(int type, int dir, int[] pos) {
            this.type = type;
            this.dir = dir;
            this.pos = pos;
        }
    }
}
