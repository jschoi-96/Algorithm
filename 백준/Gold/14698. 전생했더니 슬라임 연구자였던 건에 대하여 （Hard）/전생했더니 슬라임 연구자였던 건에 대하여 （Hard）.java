import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int unit = 1000000007;

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            long total = 1;
            for(int j = 0; j < n; j++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            if (n == 1) {
                sb.append(total).append("\n");
            }

            else {
                while(pq.size() > 1) {
                    long a = pq.poll();
                    long b = pq.poll();
                    long tmp = a * b;
                    pq.add(tmp);

                    total *= tmp % unit;
                    total %= unit;
                    //System.out.println(total);
                }
                sb.append(total).append("\n");
            }
        }
        System.out.println(sb);
    }
}
