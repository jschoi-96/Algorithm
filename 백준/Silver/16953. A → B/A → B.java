import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()); // 1 0000 0000

        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{a, 0});

        long res = -1;
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long x = cur[0], cnt = cur[1];
            if (x == b) {
                res = cnt + 1;
                break;
            }

            long x1 = x * 2;
            if (x1 <= b) q.add(new long[]{x1, cnt + 1});

            long x2 = Long.parseLong(x + "1");
            if (x2 <= b) q.add(new long[]{x2, cnt + 1});
        }
        System.out.println(res);
    }
}
