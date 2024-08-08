import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int v, e;
    static int [][] d;
    private static final int INF = 40000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        d = new int[v+1][v+1];

        for (int i = 1; i <= v; i++) {
            Arrays.fill(d[i], INF);
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = c;
        }

        for(int k = 1; k <= v; k++) {
            for(int i = 1; i <= v; i++) {
                for(int j = 1; j <= v; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        int min_val = INF;
        for(int i = 1; i <= v; i++) {
            min_val = Math.min(min_val, d[i][i]);
        }

        System.out.println(min_val == INF ? -1 : min_val);
    }
}

