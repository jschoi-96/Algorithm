class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        // [1,3,4,6] 0번째는 물을 가르킴
        
        // 반을 나눠서 앞 계산
        
        for(int i = 1; i < food.length; i++){
            int iter = food[i] / 2;
            while(iter > 0){
                answer += i;
                iter--;
            }
        }
        if (food[0] == 1) answer += "0";
        
        for(int i = food.length - 1; i > 0; i--){
            int iter = food[i] / 2;
            while (iter > 0) {
                answer += i;
                iter--;
            }
        }
        
        
        return answer;
    }
}
