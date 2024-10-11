import java.util.*;
import java.io.*;
public class Main {
    static int x, y;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        String s1 = String.valueOf(x);
        String s2 = String.valueOf(y);
        String res1 = "";
        String res2 = "";
        for(int i = s1.length() - 1; i >= 0; i--) {
            res1 += String.valueOf(s1.charAt(i));
        }
        for(int i = s2.length() -1; i >= 0; i--) {
            res2 += String.valueOf(s2.charAt(i));
        }

        int res = Integer.parseInt(res1) + Integer.parseInt(res2);
        String res3 = String.valueOf(res);
        String tmp = "";
        for(int i = res3.length() - 1; i >= 0; i--) {
            tmp += res3.charAt(i);
        }
        System.out.println(Integer.parseInt(tmp));
    }
}
