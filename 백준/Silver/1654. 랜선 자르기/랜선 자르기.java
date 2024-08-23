import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];

        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // nlog(n)
        // 4 + 3 + 2 + 2

        long lo = 0; // 랜선의 길이 최댓값이 2^31 -1
        long hi = arr[k-1];
        hi++;

        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long result = 0;
            for(int i = 0; i < arr.length; i++) {
                result += (arr[i] / mid);
            }

            if (result < n) { // n보다 작다는 뜻은 상한선을 낮춰서 자르는 갯수를 더 많이 생성해야 함
                hi = mid;
            }

            else {
                lo = mid + 1;
            }
        }
        System.out.println(lo - 1);
    }
}
