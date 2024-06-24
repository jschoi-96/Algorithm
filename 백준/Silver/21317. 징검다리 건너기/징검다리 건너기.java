import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] jump1, jump2;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        jump1 = new int[n];
        jump2 = new int[n];
        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            jump1[i] = a;
            jump2[i] = b;
        }

        k = Integer.parseInt(br.readLine());
        dfs(1, 0 , false);
        System.out.println(min);
    }

    public static void dfs(int cur, int energy, boolean isUsed) {
        if (cur == n) {
            min = Math.min(min, energy);
            return;
        }

        if (cur > n) return;

        if (cur + 1 <= n) dfs(cur + 1, energy + jump1[cur], isUsed); // 작은 점프
        if (cur + 2 <= n) dfs(cur + 2, energy + jump2[cur], isUsed);
        if (!isUsed && cur + 3 <= n) dfs(cur + 3, energy + k, true);
    }
}
