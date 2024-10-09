import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char [][] board = new char[n][m];
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = input.charAt(j);
            }
        }

        int row = 0;
        for(int i = 0; i < n; i++){
            boolean flag = true;
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                row++;
            }
        }

        int col = 0;
        for(int j = 0; j < m; j++){
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                if (board[i][j] == 'X') {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                col++;
            }
        }
        System.out.println(Math.max(row, col));
    }
}
