class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) { // 빈 병이 마트에 주는 병 개수보다 클 동안
            int mod = n / a;
            int remainder = n % a;
            answer += b * mod;
            
            n = mod * b + remainder; // 빈 병 업데이트 
        }
        
        return answer;
    }
}
