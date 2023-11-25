class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 1. 약수 개수에 해당하는 공격력을 가진 무기
        
        for(int i = 1; i <= number; i++){
            int temp = 1;
            for(int j = 1; j <= i / 2; j++){
                
                if (i % j == 0) {
                    temp++;
                }
                
                
            }
            
            if (temp > limit) temp = power;
            answer += temp;
        }
        return answer;
    }
}

// 전체를 순회할 필요 없이, 자기 자신을 약수로 미리 계산해놓고 반만 순회한다.
