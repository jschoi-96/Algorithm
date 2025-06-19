import java.util.*;
class Solution {
    int n, m;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        n = park.length;
        m = park[0].length;
        
        Arrays.sort(mats); 
        for(int k = mats.length - 1; k >= 0; k--) { // 큰 돗자리부터 계산 (시간효율)
            int x = mats[k]; // 돗자리 길이
            
            // 5일 땐 8번 수행되어야 함 
            for(int i = x - 1; i < n; i++) {
                for(int j = x - 1; j < m; j++) {
                    //System.out.println("size: " + x + " " + i + " " + j);
                    if (check(i, j, x, park)) return x;
                }
            }
        }
        return -1;
    }
    
    public boolean check(int x, int y, int size, String[][] park) {
        for(int i = x; i >= x - size + 1; i--) {
            for(int j = y; j >= y - size + 1; j--) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}