import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] arr = new int[10];
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs( 1, 0);
        System.out.println(sb);
    }

    public static void dfs(int cur, int depth) {
        if (depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // visited[i] -> 1,2,3에 대한 방문여부를 체크
        // arr[depth] -> 깊이의 여부를 체크, 최대깊이가 곧 배열의 크기가 된다.
        for(int i = cur; i <= n; i++) {
            arr[depth] = i;
            dfs(i,depth + 1);
        }
    }
}
