import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i != 0) pq.add(arr[i]);
        }

        if (pq.size() == 0) {
            System.out.println(0);
            return;
        }

        // 7, 7
        // 6, 7

        int cnt = 0;
        int cur = arr[0];
        while(cur <= pq.peek()) {
            int nxt = pq.poll();
            cur += 1;
            pq.add(nxt - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
