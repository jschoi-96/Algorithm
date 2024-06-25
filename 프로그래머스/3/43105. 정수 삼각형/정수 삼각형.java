class Solution {
    public int solution(int[][] triangle) {        
        int len = triangle.length;
        int [][] d = new int[len][len];
        d[0][0] = triangle[0][0];
        
        int max = 0;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                if (j == 0) d[i][j] = d[i-1][j] + triangle[i][j];
                else if (j == i) d[i][j] = d[i-1][j-1] + triangle[i][j];
                else {
                   d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + triangle[i][j];
                }
                max = Math.max(max, d[i][j]);
                //System.out.print(d[i][j] + " ");
            }
            //System.out.println();
        }
        return max;
    }
}