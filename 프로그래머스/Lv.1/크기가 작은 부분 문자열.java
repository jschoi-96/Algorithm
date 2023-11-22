class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len = p.length();
        
        for(int i = 0; i + len <= t.length(); i++){
            String cut = t.substring(i, i + len);
            // Integer.parseInt() 사용으로 런타임 에러 발생
            // p,t의 길이 범위가 10,000까지므로 int로 커버 안될 수 있음.
            if (Long.parseLong(cut) <= Long.parseLong(p)){
                answer++;
            } 
        }
        return answer;
    }
}
