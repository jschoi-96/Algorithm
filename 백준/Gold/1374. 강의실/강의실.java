import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int [][] time = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time[i][0] = start;
            time[i][1] = end;

            //pq.add(end);
        }

        Arrays.sort(time, (a,b) -> a[0] - b[0]); // 끝나는 시간을 작은 순서대로 큐에 저장
//        for (int[] ints : time) {
//            System.out.println(ints[0] + " " + ints[1]);
//        }

        int cnt = 1;
        pq.add(time[0][1]);
        
        for(int i = 1; i < n; i++) {
            if (time[i][0] < pq.peek()) {
                // pq.poll();
                pq.add(time[i][1]);
                cnt++;
            }
            else {
                pq.poll(); // [13,14,20,27]
                pq.add(time[i][1]); // [13,14,18,20,27]
            }
            // [14] -> [8,14] -> [8,14,27] -> [8,14,20,27] -> [8,13,14,20,27]
        }
        System.out.println(cnt);
    }
}
