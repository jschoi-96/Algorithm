import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i][j]: 길이가 i이고 마지막 숫자가 j일때 가질 수 있는 모든 경우의 수
    점화식:
        * d[i][j] = d[i-1][j-1] + d[i-1][j+1], 단 j-1>0, j+1<10
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int [][] d = new int[n+1][10];

        for(int i = 1; i <= 9; i++) { // 초기화.
            d[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                if (j == 0) d[i][j] += d[i-1][j+1];
                else if (j == 9) d[i][j] += d[i-1][j-1];
                else d[i][j] = d[i-1][j-1] + d[i-1][j+1];
                d[i][j] %= 1000000000;
            }
        }

        int sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += d[n][i];
            sum %= 1000000000;
        }
        System.out.println(sum);
    }
}