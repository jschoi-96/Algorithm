import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int [] first = new int[n/2];
        int [] second = new int[n/2];

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0) first[i/2] = num;
            else second[i/2] = num;
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int min = n; // 종유석이나 석순 둘중 하나는 무조건 다 뚫음
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 1; i <= h; i++) {
            int first_count = first.length - lowerbound(first, i);
            int second_count = second.length - lowerbound(second, h - i + 1);

            int tmp = first_count + second_count;
            countMap.put(tmp, countMap.getOrDefault(tmp, 0) + 1);
            min = Math.min(min, tmp);
        }

        System.out.println(min + " " + countMap.get(min));
    }
    // 장애물을 처음으로 부술 수 있는 index의 값
    public static int lowerbound(int [] arr, int target) {
        int lo = 0; int hi = arr.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= target) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}