import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[250000];

        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true;
        }
        isPrime[0] = false; isPrime[1] = false;

        int m = 2 * 123456;
        for(int i = 2; i <= Math.sqrt(m); i++) {
            if (isPrime[i]) {
                for(int j = i*i; j <= m; j+=i) isPrime[j] = false;
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int sum = 0;
            for(int i = n + 1; i <= 2*n; i++) {
                if (isPrime[i]) sum++;
            }
            System.out.println(sum);
        }
    }
}