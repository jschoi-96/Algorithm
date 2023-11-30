class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int left = 10; // *의 위치
        int right = 12; // # 위치
        
        for(Integer num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                left = num;
                answer.append("L");
            }
            
            else if (num == 3 || num == 6 || num == 9) {
                right = num;
                answer.append("R");
            }
            
            else { // 2,5,8,0 일때
                
                if (num == 0) num = 11; // 0일때는 11로 변환.
                // 위아래 이동 -> /3으로 계산, 양 옆으로 이동 -> %3으로 이동
                int leftDistance = Math.abs(num - left) / 3 + Math.abs(num - left) % 3;
                int rightDistance = Math.abs(num - right) / 3 + Math.abs(num - right) % 3;
                if (leftDistance < rightDistance) {
                    answer.append("L");
                    left = num;
                }
                
                else if (leftDistance > rightDistance) {
                    answer.append("R");
                    right = num;
                }
                
                else { // 거리가 같을 때 어떤 손잡이인지에 따라서 다르게 누른다.
                    if (hand.equals("left")) {
                        System.out.println(num);
                        answer.append("L");
                        left = num;
                    } 
                    else {
                        answer.append("R");
                        right = num;
                    }
                }
            }
        }
        return answer.toString();
    }
}
