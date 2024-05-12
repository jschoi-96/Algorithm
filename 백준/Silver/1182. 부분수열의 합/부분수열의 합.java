import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n, s;
    static int [] arr;
    static int count = 0;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0) count -= 1;
        System.out.println(count);
    }

    public static void dfs(int sum, int depth) {
        if (depth == n) {
            if (sum == s) {
                count++;
            }
            return;
        }
        dfs(sum + arr[depth], depth + 1); // 배열에서 값을 더하면서 넘어가는 경우
        dfs(sum, depth + 1); // 배열에서 값을 고르지 않은 경우
    }
}