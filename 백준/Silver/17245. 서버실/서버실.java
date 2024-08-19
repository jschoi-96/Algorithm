import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        long max = 0;
        long hi = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max += board[i][j];
                if (board[i][j] > hi) hi = board[i][j];
            }
        }

        long lo = 0;
        long target = max / 2;

        if (max % 2 != 0) target++;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            long res = 0;
            for(int [] nums : board) {
                for (int num : nums) {
                    if (num > mid) {
                        res += mid;
                    }

                    else {
                        res += num;
                    }
                }
            }

            if (res < target) {
                lo = mid + 1;
            }

            else { // res >= target -> 62 > 50
                hi = mid - 1;
            }
        }
        System.out.println(lo);
    }
}
