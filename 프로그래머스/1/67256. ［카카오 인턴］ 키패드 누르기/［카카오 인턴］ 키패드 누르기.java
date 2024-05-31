class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 손의 포지션을 int [] 형태로 저장
        int [] left = new int[]{3,0};
        int [] right = new int[]{3,2};
        // 왼쪽, 오른쪽 숫자가 나올 때 포지션 정보를 업데이트 해준다.
        // 2,5,8,0이 나오는 경우 왼손과 오른손의 거리를 계산하여 최소값을 찾는다.
        for(Integer num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                if (num == 1) left = new int[]{0,0};
                else if (num == 4) left = new int[]{1,0};
                else left = new int[]{2,0};
                answer += "L";
                
            }
            else if (num == 3 || num == 6 || num == 9) {
                if (num == 3) right = new int[]{0,2};
                else if (num == 6) right = new int[]{1,2};
                else right = new int []{2,2};
                answer += "R";
            }
            else {
                int [] target;
                if (num == 2) target = new int[]{0,1};
                else if(num == 5) target = new int[]{1,1};
                else if(num == 8) target = new int[]{2,1};
                else target = new int[]{3,1};
                
                int left_dist = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int right_dist = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);
                if (left_dist == right_dist) {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = target;
                    }
                    else {
                        answer += "R";
                        right = target;
                    }
                    continue;
                }
                
                int dist = Math.min(left_dist, right_dist);
                
                
                
                if (dist == left_dist) {
                    answer += "L";
                    left = target;
                }
                
                else {
                    answer += "R";
                    right = target;
                }
            }
        }
        return answer;
    }
}