import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, n, c;
    static char [][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    /*
    1. 처음에 폭탄설치를 함
    2. 폭탄이 설치되어 있지 않은 곳에 폭탄설치, 즉 모든칸이 폭탄
    3. 1에서 설치한 폭탄이 폭발하고, BFS를 돌려서 해당 좌표 및 상하좌우를 '.'로 바꿈

    n = 0 -> 초기 상태
    n = 1 -> 초기 상태
    n = 2 -> 폭탄 설치
    n = 3 -> 1초 폭탄 터짐
    n = 4 -> 폭탄 설치
    n = 5 -> 2초 폭탄 터짐
    n = 6 -> 폭탄 설치
    n = 7 -> 4초 폭탄 터짐
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for(int t = 2; t <= n; t++) {
            if (t % 2 == 0) { // 폭탄 위치를 저장함
                for(int i = 0; i < r; i++){
                    for(int j = 0; j < c; j++) {
                        if (board[i][j] == 'O')
                            queue.add(new int[]{i, j});
                        board[i][j] = 'O';
                    }
                }
            }

            else if (t % 2 != 0) {
                bfs();
            }
        }
        print();
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            int [] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            board[x][y] = '.';
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (board[nx][ny] == 'O')
                    board[nx][ny] = '.';
            }
        }
    }

    public static void print() {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}