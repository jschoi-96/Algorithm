import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 집이 있는 부분을 시작점으로 설정하고, 큐에 넣고 방문처리를 한다.
 * 2. 새로운 좌표가 큐에 들어갈 때 마다 area 1만큼 증가
 * 3. 큐를 빠져 나왔다는 것은, 더 이상 근처에 집이 없다는 뜻이므로 총 단지 수 num 1 증가
 * 처음에 집이 있는 부분을 큐에 넣을 때 방문 체크를 했어야 하는데 하지 않아서 계속 헷갈렸음
 */
public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (board[i][j] == '1' && !visited[i][j]) {
                    int area = 0;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        area++;
                        for(int dir = 0; dir < 4; dir++){
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (visited[nx][ny] || board[nx][ny] == '0') continue;
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    num++;
                    list.add(area);
                }
            }
        }
        System.out.println(num);
        Collections.sort(list);
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
