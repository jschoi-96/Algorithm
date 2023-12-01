class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 1. 읽어나가면서 x와 x가 아닌 다른글자의 횟수를 셈
        // 2. 같아질 때, 문자열 분리
        char first = s.charAt(0); // 첫번째 문자를 저장
        
        int diff = 1;
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (diff == 0) { // 차이가 0일때, first도 리셋을 해야한다
                answer++;
                first = c;
                diff = 1;
            }
            
            else if (first != c) {
                diff--;
            }
            
            else {
                diff++;      
            }
        }
        answer++;
        return answer;
    }
}
