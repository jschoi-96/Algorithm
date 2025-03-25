import java.util.Arrays;

class Solution {
    public boolean checkValidCuts(int m, int[][] rectangles) {
        int n = rectangles.length;
        int [][] X = new int[n][2];
        int [][] Y = new int[n][2];

        for(int i = 0; i < n; i++) {
            X[i][0] = rectangles[i][0];
            X[i][1] = rectangles[i][2];
            Y[i][0] = rectangles[i][1];
            Y[i][1] = rectangles[i][3];
        }
        return check(X) || check(Y);
    }

    public boolean check(int[][] A) {
        Arrays.sort(A, (a,b) -> a[0] - b[0]);

        int cnt = 0;
        int prev = A[0][1];
        for(int i = 1; i < A.length; i++) {
            if (prev <= A[i][0]) cnt++;

            prev = Math.max(prev, A[i][1]);
        }
        return cnt >= 2;
    }
}