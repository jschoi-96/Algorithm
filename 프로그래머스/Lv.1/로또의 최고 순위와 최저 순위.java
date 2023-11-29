class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // 44, 1, 0, 0, 31 25
        // 31, 10, 45, 1, 6, 19
        
        // 1. 로또 번호와 우승 숫자를 비교해서 일치하지 않는 개수를 셈
        
        int unmatch = 0;
        for(Integer lotto : lottos) {
            if (lotto == 0) unmatch++;
        }
        
        int match = 0;
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if (lottos[i] == win_nums[j]) match++;
            }
        }
        // 6개 -> 1등, 5개 -> 2등, 4개 -> 3등, 3개 -> 4등, 2개 -> 5등, 1개 -> 6등
        int max = convert(match + unmatch); 
        int min = convert(match);
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
    
    public int convert(int number){
        if (number == 6) return 1;
        else if (number == 5) return 2;
        else if (number == 4) return 3;
        else if (number == 3) return 4;
        else if (number == 2) return 5;
        else return 6;
    }
}
