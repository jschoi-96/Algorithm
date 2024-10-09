import java.util.*;
import java.io.*;
public class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int [][] board = new int[n][5];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1000 * 1000 * 1000
        int [][] check = new int[n][2];

        for(int i = 0; i < n; i++) {
            check[i][0] = i+1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = 0; k < 5; k++) {
                    if (board[i][k] == board[j][k]) {
                        check[i][1]++;
                        check[j][1]++;
                        break;
                    }
                }
            }
        }

        Arrays.sort(check, (a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        System.out.println(check[0][0]);
    }
}
