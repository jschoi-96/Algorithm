import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (n+1) * i;
        }
        System.out.println(sum);
    }
}
