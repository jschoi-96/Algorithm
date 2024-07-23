import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int abs1 = Math.abs(a);
            int abs2 = Math.abs(b);
            if (abs1 == abs2) {
                if (a > b) return 1;
                else return -1;
            }
            return abs1 - abs2;
        });

        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            }

            else {
                if (pq.isEmpty()) {
                    sb.append("0").append("\n");
                }
                else {
                    sb.append(pq.peek()).append("\n");
                    pq.poll();
                }
            }
            n--;
        }
        System.out.println(sb.toString());
    }
}