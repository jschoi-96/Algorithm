import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<int[] > list = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int[] sorted = calc(arr);
            list.add(sorted);
        }

        int cnt = 0;
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                int[] arr1 = list.get(i);
                int[] arr2 = list.get(j);
                if (Arrays.equals(arr1, arr2)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static int[] calc(int[] arr) {
        int [] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for(int value : sorted) {
            map.put(value, idx++);
        }

        int [] res = new int[arr.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
