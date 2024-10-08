import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int n, h, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int cnt = 0;
        // 16 -> 8 -> 4 -> 2
        // 32 -> 16 -> 8 -> 4
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            pq.add(arr[i]);
        }

        for(int i = 0; i < t; i++) {
            if (pq.peek() < h || pq.peek() == 1) break;

            pq.add(pq.poll() / 2);
            cnt++;
        }

        int cur = pq.peek();
        if (cur >= h) {
            System.out.println("NO");
            System.out.println(cur);
        }
        else {
            System.out.println("YES");
            System.out.println(cnt);
        }
    }
}
