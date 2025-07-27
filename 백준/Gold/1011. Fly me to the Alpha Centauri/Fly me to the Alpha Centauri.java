import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y - x;
            int max = (int)Math.sqrt(dist);

            if (max == Math.sqrt(dist)) {
                System.out.println(max * 2 - 1);
            }

            else if (dist <= max * max + max) {
                System.out.println(max * 2);
            }

            else System.out.println(max * 2 + 1);
        }
    }
}
