import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                // System.out.println(arr[i] + arr[j]);
                // sum[idx++] = arr[i] + arr[j];
                set.add(arr[i] + arr[j]);
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //System.out.println("diff: " + arr[i] + " " + arr[j] + " " + (arr[i] - arr[j]));
                if (set.contains(arr[i] - arr[j])) {
                    max = Math.max(max, arr[i]);
                }
            }
        }
        System.out.println(max);
    }
}