import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        double sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr);

        System.out.println(Math.round(sum / n)); // 산술평균
        System.out.println(arr[n/2]); // 중앙값

        // 최대빈도수
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        List<Integer> maxList = new ArrayList<>();
        for(Integer key : map.keySet()) {
            if (map.get(key) == list.get(0)) {
                maxList.add(key);
            }
        }

        Collections.sort(maxList);
        if (maxList.size() > 1) System.out.println(maxList.get(1));
        else System.out.println(maxList.get(0));

        System.out.println(arr[n-1] - arr[0]); // 범위

    }
}