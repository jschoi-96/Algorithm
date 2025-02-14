class Solution {
    int n, m;
    char [][] rotated;
    public char[][] rotateTheBox(char[][] boxGrid) {
        n = boxGrid.length;
        m = boxGrid[0].length;

        rotated = new char[m][n];
        for (char [] row : rotated) Arrays.fill(row, '.');

        for(int i = 0; i < n; i++) {
            int bottom = m - 1; // 가장 낮은 지점 추적
            for(int j = m - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') { // 방해물이 있을 때 
                    rotated[j][n - i - 1] = '*'; 
                    bottom = j - 1; 
                }

                else if (boxGrid[i][j] == '#') { // 돌멩이 
                    rotated[bottom][n - i - 1] = '#';
                    bottom--;
                }
            }
        }
        return rotated;
    }
}