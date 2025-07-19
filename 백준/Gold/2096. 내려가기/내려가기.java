import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3]; // 이전 행까지의 누적 점수 저장
        int[] minDp = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxDp[i] = num;
            minDp[i] = num;
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] maxCur = new int[3]; // 현재 행의 누적 점수 저장
            int[] minCur = new int[3];

            maxCur[0] = a + Math.max(maxDp[0], maxDp[1]);
            minCur[0] = a + Math.min(minDp[0], minDp[1]);

            maxCur[1] = b + Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
            minCur[1] = b + Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

            maxCur[2] = c + Math.max(maxDp[1], maxDp[2]);
            minCur[2] = c + Math.min(minDp[1], minDp[2]);

            for(int j = 0; j < 3; j++) {
                maxDp[j] = maxCur[j]; // 누적 행에 현재 행 값 덮어씌우기
                minDp[j] = minCur[j];
            }
        }

        int max = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[i]);
            min = Math.min(min, minDp[i]);
        }

        System.out.println(max + " " +min);
    }
}
