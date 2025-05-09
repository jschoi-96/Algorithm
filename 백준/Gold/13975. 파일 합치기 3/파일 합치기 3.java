import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            int [] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                pq.add((long)arr[i]);
            }

            if (n == 1) {
                System.out.println(arr[0]);
            }

            else {
                long total = 0;
                while (!pq.isEmpty()) {
                    if (pq.size() == 1) break;
                    long a = pq.poll();
                    long b = pq.poll();
                    long sum = a + b;
                    total += sum;
                    pq.add(sum);
                }

                System.out.println(total);
            }
        }
    }
}
