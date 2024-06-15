import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i][j]: 길이가 i고 마지막 자릿수가 j인 계단의 수
    점화식: d[i][j] = d[i-1][j-1] + d[i-1][j+1]
 */
public class Main {
    static int n;
        static int [][] d = new int[102][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++) {
                if (j > 0) d[i][j] += d[i-1][j-1]; // j가 9일때 edge case 처리
                if (j < 9) d[i][j] += d[i-1][j+1]; // j가 0일때 edge case 처리
                d[i][j] %= 1000000000;
            }
        }

        long res = 0;
        for(int i = 0; i <= 9; i++) {
            res += d[n][i];
            res %= 1000000000;
        }
        System.out.println(res);
    }
}