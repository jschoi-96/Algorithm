import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l, c;
    static char [] arr;
    static boolean [] visited;
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        String [] input = br.readLine().split(" ");
        arr = new char[c];
        visited = new boolean[c];


        for(int i = 0; i < input.length; i++){
            arr[i] = input[i].charAt(0);
        }
        Arrays.sort(arr);
        dfs(0, 0, "");
        for (String re : res) {
            System.out.println(re);
        }
    }

    public static void dfs(int start, int depth, String tmp) {
        if (depth == l && check(tmp)) {
            res.add(tmp);
            return;
        }


        for(int i = start; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, tmp + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean check(String tmp) {
        int mc = 0;
        int jc = 0;
        for (char c : tmp.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mc++;
            }
            else {
                jc++;
            }
        }
        if (mc >= 1 && jc >= 2) return true;
        return false;
    }
}