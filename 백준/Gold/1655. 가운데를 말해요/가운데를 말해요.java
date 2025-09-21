import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min_pq = new PriorityQueue<>(); // 중간값 이상의 값들
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder()); // 중간값보다 낮은 값들

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (min_pq.size() == max_pq.size()) max_pq.add(a);
            else min_pq.add(a);

            if (!min_pq.isEmpty() && max_pq.peek() > min_pq.peek()) { // maxheap이 minheap보다 큰 경우
                int tmp = max_pq.poll();
                max_pq.add(min_pq.poll());
                min_pq.add(tmp);
            }

            sb.append(max_pq.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
