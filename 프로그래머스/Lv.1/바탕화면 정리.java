import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        // 드래그 시작점 lux, luy
        // 드래그 끝 점 rux, ruy
        
        // (3,3) (3,4) (4,4) (1,5) (2,6) (2,7)
        
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    max_x = Math.max(max_x, i);
                    max_y = Math.max(max_y, j);
                    min_x = Math.min(min_x, i);
                    min_y = Math.min(min_y, j);
                }
            }
        }
        
        max_x += 1;
        max_y += 1;
        return new int [] {min_x, min_y, max_x, max_y};
    }
}
