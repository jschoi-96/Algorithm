import java.util.*;
class Point {
    public long x;
    public long y;
    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    private Point intersection(long a, long b, long e, long c, long d, long f) {
        double x = (double) (b * f - e * d) / (a * d - b * c);
        double y = (double) (e * c - a * f) / (a * d - b * c);
        
        if (x % 1 != 0 || y % 1 != 0) return null; // 정수일때만 체크
        
        return new Point((long) x, (long) y);
    }
    
    private Point getMinimumPoint(List<Point> list) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for(Point p : list) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x, y);
    }
    
    private Point getMaximumPoint(List<Point> list) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for(Point p : list) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        return new Point(x, y);
    }
    
    private char[][] createBoard (Point maxP, Point minP) {
        int x = (int) (maxP.x - minP.x + 1);
        int y = (int) (maxP.y - minP.y + 1);
        
        char [][] board = new char[y][x];
        for(char [] line : board) {
            Arrays.fill(line, '.');
        }
        
        return board;
    }
    
    
    public String[] solution(int[][] line) {        
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++){
            for(int j = i+1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection == null) {
                    continue;
                }
                points.add(intersection);
            }
        }
        Point maxPoint = getMaximumPoint(points);
        Point minPoint = getMinimumPoint(points);
        
        char [][] board = createBoard(maxPoint, minPoint);
       
        
        for(Point p : points) {
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            board[y][x] = '*';
        }
        
        String[] answer = new String[board.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = String.valueOf(board[i]);
        }
        return answer;
    }
}

