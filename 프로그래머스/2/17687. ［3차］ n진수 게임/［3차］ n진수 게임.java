class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder ans = new StringBuilder();
        
        int len = t * m; // 미리구할 숫자 * 사람 수
        int num = 0;
        
        StringBuilder sb = new StringBuilder();
        while(sb.length() < len) {
            String tmp = Integer.toString(num, n).toUpperCase();
            sb.append(tmp);
            num++;
        }
        
        // System.out.println(sb);
        int cnt = 0;
        for(int i = p - 1; i < sb.length(); i += m) {
            if (cnt == t) break;
            ans.append(sb.charAt(i));
            cnt++;
        }
        
        return ans.toString();
    }
}