class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
                
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = 0; j < index; j++){
                c += 1;
                if (c > 'z'){ // z를 넘어갈 경우 다시 a로 돌아감
                    c -= 26;
                }
                
                if (skip.contains(String.valueOf(c))) {
                    // c += 1을 안하고 j--를 하는 부분
                    j--; // skip에 포함될 경우 건너 뜀
                }
                
            }
            answer += c;
        }
        return answer;
    }
}
