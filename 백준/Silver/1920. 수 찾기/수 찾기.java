import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int [] an;
    static int [] am;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        an = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            an[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        am = new int[m];
        for(int i = 0; i < m; i++){
            am[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(an);
        // 4 1 5 2 3 -> 1 2 3 4 5
        for(int i = 0; i < m; i++) {
            if (bs(am[i])) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }

    }

    private static boolean bs(int num) {
        int st = 0; int end = an.length - 1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (num == an[mid]) return true;
            else if (num < an[mid]) end = mid - 1;
            else if (num > an[mid]) st = mid + 1;
        }
        return false;
    }
}