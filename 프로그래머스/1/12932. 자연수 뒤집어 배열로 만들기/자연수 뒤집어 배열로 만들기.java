class Solution {
    public int[] solution(long n) {
        
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        StringBuilder sb = new StringBuilder(s);
        
        String reversed = sb.reverse().toString();
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (reversed.charAt(i) - '0');
        }
        return answer;
    }
}