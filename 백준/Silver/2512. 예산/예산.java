import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    1. 배열을 정렬한다.
    2. 하한선과 상한선을 잡고, result가 총 예산보다 작다면 하한점을 높여준다.
    3. result가 총 예산보다 같거나 크다면 상한점을 낮춘다.
 */
public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long lo = 1;
        long hi = arr[n - 1];

        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            long result = 0;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] <= mid) result += arr[i];
                else result += mid;
            }

            if (result <= m) {
                lo = mid + 1;
            }

            else {
                hi = mid - 1;
            }
        }
        System.out.println(lo - 1);
    }
}
