import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k; // 격자, 파이어불 개수,
    static int[] dx = {-1,-1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());



        Queue<Ball> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new Ball(new int[]{r,c}, m, s, d));
        }

        int cnt = 0;
        while(cnt++ < k) {

            List<Ball> map [][] = new ArrayList[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            while (!q.isEmpty()) {
                Ball cur = q.poll();
                int[] pos = cur.pos;
                int x = pos[0], y = pos[1];
                int weight = cur.weight;
                int dir = cur.dir;
                int speed = cur.speed;

                // 방향 * 속도만큼 이동 (음수 처리 수정)
                int nx = ((x + dx[dir] * speed) % n + n) % n;
                int ny = ((y + dy[dir] * speed) % n + n) % n;
                map[nx][ny].add(new Ball(new int[]{nx, ny}, weight, speed, dir));
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (map[i][j].size() == 1) q.add(map[i][j].get(0));
                    else if (map[i][j].size() >= 2) {

                        List<Ball> balls = map[i][j];
                        int sumW = 0, sumS = 0;
                        boolean odd = false, even = false;
                        for(Ball b : balls) {
                            sumW += b.weight;
                            sumS += b.speed;
                            if (b.dir % 2 == 0) even = true;
                            else odd = true;
                        }

                        sumW /= 5;
                        sumS /= balls.size();
                        int [] dirs;
                        if (odd && even) dirs = new int[]{1,3,5,7};
                        else dirs = new int[]{0,2,4,6};

                        if (sumW == 0) continue;
                        for(int d : dirs) {
                            //int mx = (i + dx[d] * sumS + n) % n;
                            //int my = (j + dy[d] * sumS + n) % n;
                            q.add(new Ball(new int[]{i,j}, sumW, sumS, d));
                        }
                    }
                }
            }
        }

        int total = 0;
        while (!q.isEmpty()) {
            Ball cur = q.poll();
            total += cur.weight;
        }
        System.out.println(total);
    }

    public static class Ball {
        int[] pos;
        int weight;
        int speed;
        int dir;
        public Ball(int[] pos, int weight, int speed, int dir) {
            this.pos = pos;
            this.weight = weight;
            this.speed = speed;
            this.dir = dir;
        }
    }
}
