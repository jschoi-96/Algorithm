import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[2*n];
        boolean[] robot = new boolean[n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int round = 0;
        while (true) {

            round++;
            // 벨트 회전
            int last = arr[arr.length-1];
            for(int i = arr.length - 1; i >= 1; i--) arr[i] = arr[i-1];
            arr[0] = last;

            // 로봇 회전
            for(int i = robot.length - 1; i >= 1; i--) robot[i] = robot[i-1];
            robot[0] = false;
            robot[n-1] = false;

            // 로봇이 이동 가능한 경우에 이동
            for(int i = robot.length - 1; i >= 1; i--) {
                if (robot[i-1] && !robot[i] && arr[i] > 0) { // 이전 칸에 로봇이 있고, 현재 칸에 있고 내구도가 0보다 큰 경우
                    arr[i]--;
                    robot[i-1] = false;
                    robot[i] = true;
                }
            }

            // 올리는 칸의 내구도가 0이 아니면 로봇을 올린다.
            if (arr[0] > 0) {
                robot[0] = true;
                arr[0]--;
            }

            int cnt = 0;
            for(int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == 0) cnt++;
            }

            if (cnt >= k) break;
        }
        System.out.println(round);
    }
}