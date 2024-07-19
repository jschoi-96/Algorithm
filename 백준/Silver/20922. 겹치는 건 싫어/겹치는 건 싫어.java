import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k; // n: 정수 , k: k개 이하 겹치는 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int hi = 0;
        int result = 0;
        int[] counts = new int[100002];
        for(int lo = 0; lo < n; lo++) {
            while(hi < n && counts[arr[hi]] < k) {
                counts[arr[hi]]++;
//                System.out.println(arr[hi] + " " + counts[arr[hi]]);
                hi++;
            }

            // 같은 원소 갯수가 K가 넘을 때 루프를 빠져나온다
            result = Math.max(result, hi - lo);
            counts[arr[lo]]--;
        }
        System.out.println(result);
    }
}