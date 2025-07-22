import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] s1 = new String[n];
        for(int i = 0; i < n; i++) {
            s1[i] = br.readLine();
        }

        Arrays.sort(s1);
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            String query = br.readLine();
            if (bst(s1, query)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean bst(String[] arr, String target) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid].startsWith(target)) return true;
            if (target.compareTo(arr[mid]) > 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
