import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        int min_height = 256, max_height = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min_height = Math.min(min_height, board[i][j]);
                max_height = Math.max(max_height, board[i][j]);
            }
        }

        int min_time = Integer.MAX_VALUE;
        for(int h = 0; h <= 256; h++) {
            int time = 0;
            int temp_b = b; // 매번 인벤토리 값을 초기화하기 위해 사용
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    int diff = board[i][j] - h;

                    if (diff > 0) {
                        time += diff * 2;
                        temp_b += diff;
                    }

                    else if (diff < 0) {
                        time += Math.abs(diff);
                        temp_b += diff; // 음수니까 더해줌
                    }
                }
            }

            if (temp_b >= 0) { // 인벤토리가 0이상일 때
                if (time < min_time) {
                    min_time = time; // 시간 최소값 갱신
                    max_height = h; // 높이도 갱신.
                }

                else if (time == min_time) {
                    max_height = Math.max(max_height, h); // 답이 여러개라면, 가장 높은 높이를 출력해야함.
                }
            }
        }

        System.out.println(min_time + " " + max_height);
    }
}
