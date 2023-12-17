import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            String s = br.readLine();

            if (isPal(s)) sb.append(0).append("\n");
            else if (isPse(s)) sb.append(1).append("\n");
            else sb.append(2).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isPal(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.toString().equals(sb.reverse().toString())) return true;
        return false;
    }

    public static boolean isPse(String s) {
        int st = 0; int en = s.length() - 1;
        while(st < en) {
            if (s.charAt(st) != s.charAt(en)) {
                StringBuilder left = new StringBuilder(s).deleteCharAt(st);
                StringBuilder right = new StringBuilder(s).deleteCharAt(en);
                if (left.toString().equals(left.reverse().toString()) || right.toString().equals(right.reverse().toString())) return true;
                else return false;
            }
            st++; en--;
        }
        return false;
    }
}
