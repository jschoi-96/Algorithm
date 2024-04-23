import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int m, n;
    static int [] arr = new int[10];
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        recur(1, 0);
        System.out.println(sb.toString());
    }

    private static void recur(int start , int depth) {
        if (depth == m) {
            for(int i = 0; i < m; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i <= n; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                recur(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}