
class Solution {
    static int [] dx = {1,0,-1};
    static int [] dy = {0,1,-1};
    public int[] solution(int n) {
        
        int [][] temp = new int[n][n];
        
        int x = 0; 
        int y = 0;
        int val = 1;
        
        while (true) {
            // 아래로 이동
            while(true) {
                temp[y][x] = val++;
                if (y + 1 == n || temp[y+1][x] != 0) break;
                y += 1;
            }
            
            // 오른쪽으로 진행 x 
            if (x + 1 == n || temp[y][x+1] != 0) break;
            x += 1;
        
            // 오른쪽으로 이동
            while (true) {
                temp[y][x] = val++;
                if (x + 1 == n || temp[y][x+1] != 0) break;
                x += 1;
            }
            
            // 왼쪽 위로 이동x
            if (temp[y-1][x-1] != 0) break;
            x -= 1;
            y -= 1;
        
            // 반시계 방향으로 이동
            while(true) {
                temp[y][x] = val++;
                if (temp[y-1][x-1] != 0) break;
                x -= 1;
                y -= 1;
            }
            
            if (y + 1 == n || temp[y+1][x] != 0) break;
            y += 1;
        }
        
        int[] answer = new int[val - 1];
        int idx = 0;
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j <= i; j++) {
                answer[idx++] = temp[i][j];
            }
        }
        return answer;
    }
}