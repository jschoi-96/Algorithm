import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int r, c, t;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[r][c];

        List<Integer> start = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) start.add(i);
            }
        }

        while (t > 0) {
            spread();
            upperAir(start.get(0));
            downAir(start.get(1));
            //printBoard(board);
            t--;
        }

        System.out.println(calculate(board));
    }

    public static int calculate(int[][] board) {
        int amount = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (board[i][j] != -1) amount += board[i][j];
            }
        }
        return amount;
    }

    public static void spread() {

        int[][] tmp = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (board[i][j] != 0 && board[i][j] != -1) {
                    int cnt = 0;
                    int amount = board[i][j] / 5;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                        if (board[nx][ny] == -1) continue;
                        cnt++;
                        tmp[nx][ny] += amount; // 확산되는 양
                    }

                    tmp[i][j] -= amount * cnt;
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                board[i][j] += tmp[i][j];
            }
        }
    }

    public static void upperAir(int pos) {
        int [][] tmp = new int[r][c];
        for(int i = 1; i < c - 1; i++) { // 오른쪽
            tmp[pos][i+1] = board[pos][i];
        }

        for(int i = pos; i > 0; i--) { // 위
            tmp[i-1][c-1] = board[i][c-1];
        }

        for(int i = c - 1; i > 0; i--) {
            tmp[0][i-1] = board[0][i];
        }

        for(int i = 1; i < pos; i++) {
            tmp[i][0] = board[i-1][0];
        }
        setBoard(pos, tmp);
        //printBoard(board);
    }

    public static void downAir(int pos) {
        int [][] tmp = new int[r][c];
        for(int i = 1; i < c-1; i++) { // 오른쪽
            tmp[pos][i+1] = board[pos][i];
        }

        for(int i = pos; i < r - 1; i++) { // 아래
            tmp[i+1][c-1] = board[i][c-1];
        }

        for(int i = c - 1; i > 0; i--) { // 왼쪽
            tmp[r-1][i-1] = board[r-1][i];
        }

        for(int i = r - 1; i > pos + 1; i--) { // 위
            tmp[i-1][0] = board[i][0];
        }

        setDownBoard(pos, tmp);
        //printBoard(tmp);
    }

    public static void setBoard(int pos, int[][] tmp) {
        for(int i = 1; i < c; i++) { // 오른쪽
            board[pos][i] = tmp[pos][i];
        }

        for(int i = pos; i > 0; i--) { // 위
            board[i][c-1] = tmp[i][c-1];
        }

        for(int i = c - 1; i > 0; i--) {
            board[0][i] = tmp[0][i];
        }

        for(int i = 0; i < pos; i++) {
            board[i][0] = tmp[i][0];
        }
    }

    public static void setDownBoard(int pos, int[][] tmp) {
        for(int i = 1; i < c; i++) {
            board[pos][i] = tmp[pos][i];
        }

        for(int i = pos; i < r; i++) {
            board[i][c-1] = tmp[i][c-1];
        }

        for(int i = c - 1; i >= 0; i--) {
            board[r-1][i] = tmp[r-1][i];
        }

        for(int i = r - 1; i > pos; i--) {
            board[i][0] = tmp[i][0];
        }
    }

    public static void printBoard(int[][] board) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

