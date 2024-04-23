import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int m, n;
    static int [] arr;
    static int [] tmp = new int[10];
    static boolean[] visited = new boolean[10000];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recur(0);
        System.out.println(sb.toString());
    }

    private static void recur(int depth) {
        if (depth == m) {
            for(int i = 0; i < m; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                tmp[depth] = arr[i];
                recur(depth + 1);
                visited[arr[i]] = false;
            }
        }
    }

}