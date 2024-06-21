import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i][j]: 현재까지 j개의 계단을 연속해서 밟고 i번째 계단까지 올라섰을 때 최대값 (단, i번째는 밟아야함)
    점화식:
        * d[k][1] = max(d[k-2][1], d[k-2][2]) + s[k]
        * d[k][2] = d[k-1][1] + s[k]
 */
public class Main {
    static int n;
    static int s[] = new int[10002];
    static int d[][] = new int[10002][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }

        d[1][1] = s[1]; d[1][2] = 0;
        d[2][1] = s[2]; d[2][2] = s[1] + s[2];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        for(int i = 2; i <= n; i++) {
            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + s[i];
            d[i][2] = d[i - 1][1] + s[i];
        }

        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}