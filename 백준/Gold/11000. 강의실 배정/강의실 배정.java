
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> end = new PriorityQueue<>();
        end.add(0);

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b});
        }

        while(!pq.isEmpty()) {
            int [] cur = pq.poll();

            if (end.peek() <= cur[0]) {
                end.poll();
            }
            end.add(cur[1]);
        }
        System.out.println(end.size());
    }
}
