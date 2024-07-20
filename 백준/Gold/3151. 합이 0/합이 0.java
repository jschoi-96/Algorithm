import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[20002];
        int [] cnt = new int[20002]; // 등장횟수를 저장하는 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i] + 10000]++;
        }

        long answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (Math.abs(sum) > 10000) continue;

                answer += cnt[10000 - sum];

                // 현재 보고 있는값과 동일하다면 결과 -1
                if (arr[i] == -sum) answer--;
                if (arr[j] == -sum) answer--;
            }
        }
        System.out.println(answer/3);
    }
}