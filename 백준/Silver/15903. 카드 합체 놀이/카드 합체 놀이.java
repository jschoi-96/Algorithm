import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(long i = 0; i < n; i++) {
            long l = Long.parseLong(st.nextToken());
            pq.add(l);
        }

        // n = 1000, m = 15000
        // ai = 1000000
        for(long i = 0; i < m; i++) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            pq.add(num1 + num2);
            pq.add(num1 + num2);
        }

        long res = 0;
        while(!pq.isEmpty()) {
            res += pq.poll();
        }
        System.out.println(res);
    }
}
