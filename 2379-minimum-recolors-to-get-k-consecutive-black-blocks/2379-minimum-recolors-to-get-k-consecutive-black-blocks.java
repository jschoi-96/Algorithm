class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int hi = 1;

        int cnt = 0;
        for(int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') cnt++;
        }

        int minOperation = cnt;

        for(int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') cnt--;
            if (blocks.charAt(i) == 'W') cnt++;
            minOperation = Math.min(minOperation, cnt);
        }
        return minOperation;
    }
}