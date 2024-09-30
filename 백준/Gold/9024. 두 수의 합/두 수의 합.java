import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int [] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int lo = 0, hi = n - 1;
            int res = 0;
            // 순회하며 k에 가장 가까운 합을 갱신해준다

            int min = Integer.MAX_VALUE;
            int count = 1;
            while(lo < hi) {
                int sum = arr[lo] + arr[hi];
                int diff = Math.abs(k - sum); // k값과 가까운지 판단

                if (diff < min) { // 더 작은 값으로 갱신이 가능하다면 횟수를 초기화 해준다.
                    min = diff;
                    count = 1;
                }

                else if (min == diff) { // 동일한 값이 존재할 때, count를 증가시켜줌
                    count++;
                }

                if (sum <= k) lo++; // 현재 합이 k보다 작다면 하한점 높여줌
                else if (sum > k) hi--; // 크다면 상한점 낮춰줌

            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
