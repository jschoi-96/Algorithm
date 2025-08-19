import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int res = 0;
        int cnt = 0;
        for(int i = 1; i < m - 1; i++) {
            if (s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                cnt++; // IOI 개수 증가.
                i++; // 다음 지점 탐색.
            }

            else cnt = 0;

            if (cnt >= n) res++;
        }
        System.out.println(res);
    }
}