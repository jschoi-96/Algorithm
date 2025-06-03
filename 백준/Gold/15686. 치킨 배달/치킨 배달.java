import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int[] arr;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) houses.add(new int[]{i,j});
                else if (board[i][j] == 2) chickens.add(new int[]{i,j});
            }
        }

        dfs(0, 0);
        System.out.println(res);
    }

    public static void dfs(int depth, int nxt) {
        if (depth == m) {
            cal();
//            for(int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
            return;
        }

        for(int i = nxt; i < chickens.size(); i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void cal() {
        int d = 0;
        for(int [] house : houses) {
            int x1 = house[0];
            int y1 = house[1];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++) {
                int x2 = chickens.get(arr[i])[0];
                int y2 = chickens.get(arr[i])[1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                min = Math.min(min, dist);
            }
            d += min;
        }
        res = Math.min(d, res);
    }
}
