// 시간 초과 코드

class Solution {
    public int solution(int n) {
        int answer = 0;
                
        String ori = Integer.toBinaryString(n);
        ori = ori.replaceAll("0", "");
        int count = ori.length();
        
        int tmp = n;
        while(true) {
            tmp++;
            String s = Integer.toBinaryString(tmp);
            s = s.replaceAll("0" , "");
            if (count == s.length()) break;
            
        }
        return tmp;
    }
}

// bitCount 풀이
class Solution {
    public int solution(int n) {
        
        int count = Integer.bitCount(n);
        while(true) {
            n++;
            if (Integer.bitCount(n) == count) {
                break;
            }
        }
        return n;
    }
}
