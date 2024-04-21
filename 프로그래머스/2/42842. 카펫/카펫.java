class Solution {
    public int[] solution(int brown, int yellow) {        
        // 갈색 == 전체 가로, 길이 
        // 전체 가로 = 노랑 + 2
        // 전체 세로 = 노랑 + 2
        
        int area = brown + yellow;
        int row = 0; int col = 3;
        for(int i = 3; i <= area; i++) {
            int j = area / i; // 길이가 3을 넘는지 체크
            
            if (area % i == 0 && j >= 3) {
                row = Math.max(row, i);
                col = Math.min(j, i);
                
                int center = (row - 2) * (col - 2);
                if (center == yellow) {
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{};
    }
}