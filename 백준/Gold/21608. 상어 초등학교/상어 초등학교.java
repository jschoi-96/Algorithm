import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[][] tmp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        tmp = new int[n][n];

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for(int i = 1; i <= n*n; i++) map.put(i, new ArrayList<>());

        for(int t = 0; t < n*n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < 4; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }
            map.put(target, tmp);

            PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> {
                if (a.likeCnt != b.likeCnt) return b.likeCnt - a.likeCnt;
                if (a.emptyCnt != b.emptyCnt) return b.emptyCnt - a.emptyCnt;
                if (a.row != b.row) return a.row - b.row;
                return a.col - b.col;
            });

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (board[i][j] != 0) continue;

                    int emptyCnt = 0;
                    int likeCnt = 0;
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (board[nx][ny] == 0) emptyCnt++;
                        if (tmp.contains(board[nx][ny])) likeCnt++;
                    }

                    pq.add(new Point(likeCnt, emptyCnt, i, j));
                }
            }


            Point p = pq.poll();
            board[p.row][p.col] = target;
        }

        int total = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                List<Integer> likes = map.get(board[i][j]);
                int cur = board[i][j];
                int cnt = 0;
                for(int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (likes.contains(board[nx][ny])) cnt++;
                }

                if (cnt == 1) total += 1;
                else if (cnt == 2) total += 10;
                else if (cnt == 3) total += 100;
                else if (cnt == 4) total += 1000;
            }
        }
        System.out.println(total);


    }

    static class Point {
        int likeCnt;
        int emptyCnt;
        int row;
        int col;
        public Point(int likeCnt, int emptyCnt, int row, int col) {
            this.likeCnt = likeCnt;
            this.emptyCnt = emptyCnt;
            this.row = row;
            this.col = col;
        }
    }
}
