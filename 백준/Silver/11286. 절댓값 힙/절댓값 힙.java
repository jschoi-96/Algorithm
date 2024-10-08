import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return Integer.compare(a, b);
            }
            return Integer.compare(Math.abs(a) , Math.abs(b));
        });

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }

            else {
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}
