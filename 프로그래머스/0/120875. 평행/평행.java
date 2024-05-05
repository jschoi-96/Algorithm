import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        double a1 = (double) (dots[1][1] - dots[0][1]) / (double) (dots[1][0] - dots[0][0]);
        double a2 = (double)(dots[3][1] - dots[2][1]) / (double)(dots[3][0] - dots[2][0]);
        double a3 = (double)(dots[2][1] - dots[1][1]) / (double)(dots[2][0] - dots[1][0]);
        double a4 = (double)(dots[3][1] - dots[0][1]) / (double)(dots[3][0] - dots[0][0]);
        double a5 = (double)(dots[2][1] - dots[0][1]) / (double)(dots[2][0] - dots[0][0]);
        double a6 = (double)(dots[3][1] - dots[1][1]) / (double)(dots[3][0] - dots[1][0]);
        
        if (a1 == a2 || a3 == a4 || a5 == a6) return 1;
        return 0;
    }
    
    private double func(int x1, int y1, int x2, int y2) {
        return (y2 - y1) / (x2 - x1);
    }
}