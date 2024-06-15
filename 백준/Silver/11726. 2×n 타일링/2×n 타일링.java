import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int [] d = new int[1002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }

        System.out.println(d[n]);
    }
}