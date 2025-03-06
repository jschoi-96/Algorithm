class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int [] occur = new int[n * n + 1];

        for(int [] num : grid) {
            for(int i = 0; i < num.length; i++) {
                occur[num[i]]++;
            }
        }

        int [] res = new int[2];
        for(int i = 1; i <= n*n; i++) {
            if (occur[i] > 1) res[0] = i;
            else if (occur[i] == 0) res[1] = i;
        }
        return res;
    }
}