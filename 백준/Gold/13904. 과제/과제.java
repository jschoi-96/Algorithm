import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

       List<int[]> list = new ArrayList<>();

       int maxDay = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new int[]{d, w});
            maxDay = Math.max(maxDay, d);
        }

        list.sort((a,b) -> b[0] - a[0]); // 마감일 높은 순서대로 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0;
        int idx = 0;

        for(int i = maxDay; i >= 1; i--) {
            while(idx < n && list.get(idx)[0] >= i) {
                pq.add(list.get(idx)[1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }
        System.out.println(total);
    }
}
