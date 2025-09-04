import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) { // 20
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) { // 10만
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 서류 성적 순위
                int b = Integer.parseInt(st.nextToken()); // 면접 성적 순위
                arr[i][0] = a;
                arr[i][1] = b;
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);


            int cnt = 1;
            int minRank = arr[0][1];
            for(int i = 1; i < n; i++) {
                if (arr[i][1] > minRank) continue;

                minRank = arr[i][1];
                cnt++;
            }

            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
