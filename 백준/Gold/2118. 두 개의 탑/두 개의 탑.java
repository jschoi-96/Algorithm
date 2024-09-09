import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int [] arr = new int[n+1];

        long total = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        arr[n] = arr[0];


        int lo = 0, hi = 0;
        long res = 0;
        long tmp = arr[lo];

        while(lo <= hi && hi < n) {
            if (tmp < total - tmp) { // 현재 값이 나머지보다 작다면
                res = Math.max(res, tmp);
                tmp += arr[++hi]; // hi 포인터 증가
            }
            else { // 현재 값이 나머지보다 클 떄,
                res = Math.max(res, total - tmp);
                tmp -= arr[lo++];
            }
        }
        System.out.println(res);
    }
}