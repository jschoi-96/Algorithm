import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return Integer.compare(a[1], b[1]);
        });
        // 끝나는 시간을 기준으로 내림차순 정렬
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new int[]{start,end});
        }

        int[] before = new int[]{0, 0};
        int cnt = 0;
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            if (before[1] <= cur[0]) {
                before[0] = cur[0];
                before[1] = cur[1];
                //System.out.println(before[0] + " " + before[1]);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
