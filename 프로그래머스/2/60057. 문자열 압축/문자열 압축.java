class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if (s.length() == 1) {
            return 1;
        }
        for(int i = 1; i <= s.length() / 2; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String base = s.substring(0,i);
            for (int j = i; j <= s.length(); j+=i) {
                
                String cur;
                if (j+i > s.length()) {
                    cur = s.substring(j);
                } 
                else {
                    cur = s.substring(j,j+i);
                }
               
                if (base.equals(cur)) {
                    count++;
                } 
                else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(base);
                    base = cur; // base값 재정의
                    count = 1;
                }
            }
            
            if (count > 1) {
                sb.append(count);
            }
            sb.append(base);
            //System.out.println(sb.toString());
            answer = Integer.min(answer, sb.length());
        }
        
        return answer;
    }
}