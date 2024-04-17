class Solution {
    public int solution(int n) {        
        String str = Integer.toString(n,3);
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();        
        return Integer.parseInt(reversed, 3);
    }
}