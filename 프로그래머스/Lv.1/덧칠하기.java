class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int area = 0;
        
        for(int i = 0; i < section.length; i++){
            
            // 칠해지지 않은 구역이 현재 칠해진 구역보다 클 때, 
            if (section[i] > area) {
                answer++;
                area = section[i] + m - 1; // 페인트 구역을 업데이트 해준다
            }
        }
        return answer;
    }
}
