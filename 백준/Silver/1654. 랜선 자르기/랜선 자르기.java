import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int [] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. arr를 오름차순으로 정렬
        Arrays.sort(arr);

        // 2. 이분탐색을 통해 mid값으로 계속 나눴을 때 k값과 비교를 진행한다.
        long hi = arr[k - 1];
        hi++;

        long lo = 0;
        while(lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid == 0) continue;
            long cnt = 0;
            for(int num : arr) cnt += num / mid;

            // 최대 랜선의 길이를 구해야 하므로 cnt가 k이상일 때 하방값을 올려준더.
            if (cnt >= n) lo = mid + 1;
            else hi = mid;

            // System.out.println(lo + " " + hi);
        }

        System.out.println(lo - 1);
    }
}
