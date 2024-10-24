import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [][] board;
    static int [] arr;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int min_total = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        arr = new int[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) houses.add(new int[]{i,j});
                else if (board[i][j] == 2) chickens.add(new int[]{i,j});
            }
        }

        dfs(0, 0);
        System.out.println(min_total);
    }

    public static void dfs(int start, int depth) {
        if (depth == m) {
            cal();
            return;
        }

        for(int i = start; i < chickens.size(); i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    public static void cal() {

        int total = 0;
        for(int [] house : houses) {
            int x = house[0];
            int y = house[1];
            int min_dist = Integer.MAX_VALUE;
            for(int idx : arr) {
                int [] chicken = chickens.get(idx);
                int nx = chicken[0];
                int ny = chicken[1];
                int dist = Math.abs(nx - x) + Math.abs(ny - y);
                min_dist = Math.min(min_dist, dist);
            }
            total += min_dist;
        }
        min_total = Math.min(min_total , total);
        //System.out.println(total);
    }
}
