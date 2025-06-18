import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Integer> list;
    static boolean[][] visited = new boolean[102][102];
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            checkDir(d, g);
            checkPos(x, y);
        }
        countCurve();
        System.out.println(res);
    }

    public static void checkDir(int d, int g) { // 2^g만큼 리스트에 추가됨
        list.add(d); // 처음 방향값 저장

        // 이전 단계에서 거꾸로 뒤집고 90도 회전을 해서 더해줌
        for(int i = 0; i < g; i++) {
            for(int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }
    }

    public static void checkPos(int x, int y) {
        visited[x][y] = true;
        for(Integer dir : list) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            visited[nx][ny] = true;
            x = nx;
            y = ny;
        }
    }

    public static void countCurve() {
        for(int i = 0; i <= 99; i++) {
            for(int j = 0; j <= 99; j++) {
                if (visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]) res++;
            }
        }
    }
}
