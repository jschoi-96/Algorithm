import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String input = br.readLine();
        String[] arr = input.split(" ");

        int[] occur = new int[4];
        for (int i = 0; i < 4; i++) {
            occur[i] = Integer.parseInt(arr[i]);
        }

        int[] curOccur = new int[4];

        // A C G T
        for(int i = 0; i < p; i++) {
            char c = s.charAt(i);
            if (c == 'A') curOccur[0]++;
            else if (c == 'C') curOccur[1]++;
            else if (c == 'G') curOccur[2]++;
            else if (c == 'T') curOccur[3]++;
        }

        int res = 0;
        for(int i = 0; i <= n - p; i++) {
            if (isPossible(occur, curOccur)) res++;
            char c = s.charAt(i);

            if (i + p == n) {
                isPossible(occur, curOccur);
                break;
            }

            char next = s.charAt(i + p);
            if (c == 'A') curOccur[0]--;
            else if (c == 'C') curOccur[1]--;
            else if (c == 'G') curOccur[2]--;
            else if (c == 'T') curOccur[3]--;

            if (next == 'A') curOccur[0]++;
            else if (next == 'C') curOccur[1]++;
            else if (next == 'G') curOccur[2]++;
            else if (next == 'T') curOccur[3]++;
        }

        System.out.println(res);
    }

    public static boolean isPossible(int[] occur, int[] curOccur) {
        return curOccur[0] >= occur[0] && curOccur[1] >= occur[1] && curOccur[2] >= occur[2] && curOccur[3] >= occur[3];
    }
}
