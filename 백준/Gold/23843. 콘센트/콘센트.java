import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.add(arr[i]);
        }

        int [] time = new int[m];
        while(!pq.isEmpty()) {

            int max = Integer.MAX_VALUE;
            for(int i = 0; i < m; i++) {
                max = Math.min(max, time[i]);
            }

            for(int i = 0; i < m; i++) {
                if (time[i] == max && !pq.isEmpty()) {
                    //System.out.println("max: " + max);
                    time[i] += pq.poll();
                    // System.out.println(time[i]);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < time.length; i++) {
            res = Math.max(res, time[i]);
        }
        System.out.println(res);
    }
}
