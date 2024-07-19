import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
        1. 원소를 순회하며 홀수인 경우 삭제한다.
        2. 삭제 횟수가 k번 초과한 경우, 루프를 빠져나와 max값을 갱신한다.
     */
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int hi = 0;
        int delete = 0;
        int total_delete = 0;
        int max = 0;

        for(int lo = 0; lo < n; lo++) {
            while(hi < n && delete <= k) {
                if (arr[hi] % 2 != 0) {
                    delete++;
                    total_delete++;
                }
                hi++;
            }

            if (hi == n) break;
//            System.out.println(arr[lo]);
//            System.out.println("현재 위치: " + hi + " 현재 값: " + arr[hi]);

            int len = hi - lo - delete;
            // if (arr[lo] % 2 == 0) len++; // 시작 값이 짝수일 경우 1을 더해줌

            max = Math.max(max, len);
            if (arr[lo] % 2 != 0) {
                delete--;
            }
        }

        if (total_delete <= k) { // 전체 순회했음에도 삭제 횟수가 k보다 작을 때
            System.out.println(n - total_delete);
        }
        else System.out.println(max);
    }
}