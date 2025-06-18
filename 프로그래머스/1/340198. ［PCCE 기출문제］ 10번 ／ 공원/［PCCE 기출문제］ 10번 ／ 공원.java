import java.util.*;
class Solution {
    int n, m;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        n = park.length;
        m = park[0].length;
        
        Arrays.sort(mats); 
        for(int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            for(int x = 0; x <= n - size; x++) { // 3
                for(int y = 0; y <= m - size; y++) { // 1
                    if (isPossible(x,y,size,park)) return size;
                }
            }
        }
        return -1;
    }
    
    public boolean isPossible(int x, int y, int size, String[][] park) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}