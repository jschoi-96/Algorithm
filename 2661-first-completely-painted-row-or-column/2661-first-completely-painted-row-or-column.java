class Solution {
    int m, n, len;
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        m = mat.length;
        n = mat[0].length;
        len = m * n;

        int [] rowCnt = new int[m];
        int [] colCnt = new int[n];
        Arrays.fill(rowCnt, n);
        Arrays.fill(colCnt, m);

        // [값, 위치]
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i,j});
            }
        }

        int moves = 0;
        for(int i = 0; i < len; i++) {
            int [] pos = map.get(arr[i]);
            int x = pos[0];
            int y = pos[1];
            // System.out.println(pos[0] + " " + pos[1]);

            rowCnt[x]--;
            colCnt[y]--;
            System.out.println(rowCnt[x] + " " + colCnt[y]);
            if (rowCnt[x] == 0 || colCnt[y] == 0) {
                return i;
            }
        }

        return 0;
    }
}