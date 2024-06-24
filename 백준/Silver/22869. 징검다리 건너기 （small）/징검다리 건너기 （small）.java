import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] s = new int[n + 1];
        int[] d = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[1] = 0;  // 시작점은 에너지가 필요하지 않음

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int energy = (j - i) * (1 + Math.abs(s[i] - s[j]));
                if (energy <= k && d[i] != Integer.MAX_VALUE) {
                    d[j] = Math.min(d[j], d[i] + energy);
                }
            }
        }

        if (d[n] != Integer.MAX_VALUE) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
