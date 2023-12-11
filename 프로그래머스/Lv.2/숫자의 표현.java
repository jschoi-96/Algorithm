// 시간초과 난 풀이
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int tmp = 0;
            for(int j = i; j <= n; j++){
                tmp += j;
                if (tmp == n) {
                    answer++;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}

// tmp가 n을 넘을 때 break 처리
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int tmp = 0;
            for(int j = i; j <= n; j++){
                tmp += j;
                if (tmp == n) {
                    answer++;
                    break;
                }
                
                else if (tmp > n) break;
            }
        }
        
        return answer;
    }
}
