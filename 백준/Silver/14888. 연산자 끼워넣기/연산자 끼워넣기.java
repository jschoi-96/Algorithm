import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [] cal = new int[4];
    static int [] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        // +, -, x, /
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]); // 초기값을 저장
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int cur) {
        if (depth == n) {
            max = Math.max(cur, max);
            min = Math.min(cur, min);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;
                if (i == 0) {
                    dfs(depth + 1, cur + arr[depth]);
                    //dfs(depth + 1, cur - arr[depth]);
                }
                else if (i == 1) {
                    dfs(depth + 1, cur - arr[depth]);
                    //dfs(depth + 1, cur + arr[depth]);
                }
                else if (i == 2) {
                    dfs(depth + 1, cur * arr[depth]);
                    //dfs(depth + 1, cur / arr[depth]);
                }
                else if (i == 3) {
                    dfs(depth + 1, cur / arr[depth]);
                    //dfs(depth + 1, cur * arr[depth]);
                }
                cal[i]++;
            }
        }
    }
}
