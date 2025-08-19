import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String s = br.readLine();

        if (m < 3) {
            System.out.println(0);
            return;
        }

        String base = "IOI";

        n -= 1;
        while(n > 0) {
            base += "OI";
            n--;
        }

        int len = base.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
        }

        int res = 0;
        if (base.equals(sb.toString())) res++;

        for(int i = len; i < m; i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            if (base.equals(sb.toString())) res++;
        }

        System.out.println(res);
    }
}
