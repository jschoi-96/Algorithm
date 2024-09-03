import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean [][] coin;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coin  = new boolean[n][m];
        /*
        00
        01

        (2,2)뒤집을 떄
        (1,1) (1,2), (2,1) (2,2)

        11
        10

        (1,2) 뒤집을 떄
        (1,1) (1.2)


        00
        10

        (2,1) 뒤집을 때
        (1,1) (2,1)

        10
        00

        00
        00

        (1,1
         */
        // 모든 숫자가 0
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                if (input.charAt(j) == '1') {
                    coin[i][j] = true;
                }
            }
        }

        for(int j = m - 1; j >= 0; j--){
            for(int i = n - 1; i >= 0; i--){
                if (coin[i][j]) {
                    reverse(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void reverse(int a, int b) {
        for(int i = 0; i <= a; i++){
            for(int j = 0; j <= b; j++) {
                coin[i][j] = !coin[i][j];
            }
        }
    }
}
