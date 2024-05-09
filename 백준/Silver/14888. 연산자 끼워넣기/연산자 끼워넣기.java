import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int [] nums;
    static int [] cal = new int [4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 계산 배열을 순회하며
        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int depth) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++){
            if (cal[i] > 0) {
                cal[i]--;
                switch(i) {
                    case 0: dfs(num + nums[depth] , depth + 1); break;
                    case 1: dfs(num - nums[depth] , depth + 1); break;
                    case 2: dfs(num * nums[depth] , depth + 1); break;
                    case 3: dfs(num / nums[depth] , depth + 1); break;
                }
                cal[i]++;
            }
        }
    }
}