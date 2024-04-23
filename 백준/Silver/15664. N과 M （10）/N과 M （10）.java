import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int m, n;
    static int [] arr;
    static int [] tmp;
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tmp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        recur(0, 0);
        System.out.println(sb.toString());
    }

    private static void recur(int start, int depth) {
        if (depth == m) {
            for(int i = 0; i < depth; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        // 1 7 9 9
        for(int i = start; i < n; i++){
            if (visited[i]) continue;
            if (prev != arr[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                prev = arr[i];
                recur(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}