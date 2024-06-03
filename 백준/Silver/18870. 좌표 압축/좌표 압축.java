import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int [] sortedArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if (i == 0 || sortedArr[i-1] != sortedArr[i]) {
                list.add(sortedArr[i]);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) map.put(list.get(i), i);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}