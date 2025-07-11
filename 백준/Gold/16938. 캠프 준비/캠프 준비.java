import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r, x;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken()); // 문제 난이도 합이 l이상
        r = Integer.parseInt(st.nextToken()); // 합이 r 이하
        x = Integer.parseInt(st.nextToken()); // 가장 어려운 문제, 쉬운문제 차이가 x이상

        int[] arr = new int[n];

        // A[i] -> 100 0000
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0, 0, Integer.MAX_VALUE, 0, arr);
        System.out.println(res);
    }

    public static void dfs(int sum, int idx, int max, int min, int size, int[] arr) {
        if (idx == n) {
            if (size >= 2 && sum >= l && sum <= r && max - min >= x) {
                res++;
            }
            return;
        }

        // 선택한 경우
        dfs(sum + arr[idx], idx + 1, Math.max(max, arr[idx]), Math.min(min, arr[idx]), size + 1, arr);
        // 선택하지 않은 경우
        dfs(sum, idx + 1, max, min, size, arr);
    }
}
