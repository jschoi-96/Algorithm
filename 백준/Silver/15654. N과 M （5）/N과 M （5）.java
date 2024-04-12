import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int [] arr;
    static int [] tmp;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tmp = new int[m];
        visited = new boolean[10];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs( 0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for(int i = 0; i < depth; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                tmp[depth] = arr[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}