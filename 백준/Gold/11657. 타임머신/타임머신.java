import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [][] d;
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new int[n+2][n+2];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c); //
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if (d[i][k] < INF && d[k][j] < INF) // 경로가 존재하는 경우에만
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if (d[i][i] < 0) {
                flag = true;
                break;
            }
        }

        for(int i = 2; i <= n; i++) {
            if (d[1][i] != INF && flag) { //
                System.out.println(-1);
                return;
            } else {
                sb.append(d[1][i] == INF ? -1 : d[1][i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
