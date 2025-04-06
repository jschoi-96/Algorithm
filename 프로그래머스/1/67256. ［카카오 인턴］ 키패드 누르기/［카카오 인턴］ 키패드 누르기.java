class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        char [][] board = {{'1','2','3'}, {'4','5','6'},{'7','8','9'},{'*','0','#'}};
        
        int [] left_pos = new int[2];
        int [] right_pos = new int[2];
        
        // 초기값 설정
        left_pos[0] = 3; left_pos[1] = 0;
        right_pos[0] = 3; right_pos[1] = 2;
        
        for(int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                for (int i = 0; i < 3; i++) {
                    // 왼쪽 좌표값 갱신
                    if (board[i][0] - '0' == number) {
                        left_pos[0] = i;
                        left_pos[1] = 0;
                        answer += "L";
                    }
                }
            }
            
            else if (number == 3 || number == 6 || number == 9) {
                for(int i = 0; i < 3; i++) {
                    // 오른쪽 좌표값 갱신
                    if (board[i][2] - '0' == number) {
                        right_pos[0] = i;
                        right_pos[1] = 2;
                        answer += "R";
                    }
                }
            }
            
            else {
                int [] cur = new int[2];
                for(int i = 0; i < 4; i++) {
                    if (board[i][1] - '0' == number) {
                        cur[0] = i;
                        cur[1] = 1;
                    }
                }
                
                int left_dist = Math.abs(cur[0] - left_pos[0]) + Math.abs(cur[1] - left_pos[1]);
                int right_dist = Math.abs(cur[0] - right_pos[0]) + Math.abs(cur[1] - right_pos[1]);
                if (left_dist < right_dist) {
                    left_pos[0] = cur[0];
                    left_pos[1] = cur[1];
                    // 거리를 다시 설정해야함.
                    answer += "L";
                }
                
                else if (left_dist > right_dist) {
                    right_pos[0] = cur[0];
                    right_pos[1] = cur[1];
                    answer += "R";
                }
                
                else {
                    if (hand.equals("left")) {
                        left_pos[0] = cur[0];
                        left_pos[1] = cur[1];
                        answer += "L";
                    }
                    else {
                        right_pos[0] = cur[0];
                        right_pos[1] = cur[1];
                        answer += "R";
                    }
                }
            }
        }
        return answer;
    }
}