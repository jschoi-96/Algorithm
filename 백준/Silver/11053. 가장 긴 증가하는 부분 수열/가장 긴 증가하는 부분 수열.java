import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i]: i번째 원소를 마지막으로 가지는 수열의 길이
    점화식: d[i] = max(d[i], d[j] + 1)
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) { // 초기화 자기 자신만으로 부분 수열 구성 가능
            d[i] = 1;
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}