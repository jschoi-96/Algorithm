import java.util.*;
class Solution {
    // 1. 배열을 정렬을 한다.
    // 2. 배열의 뒤에서 부터 순회를 하면서 
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int h = citations.length; h >= 1; h--) {
            if (isValid(citations, h)) return h;
        } 
        return 0;
    }
    
    public boolean isValid(int [] citations, int h) {
        int idx = citations.length - h;
        return citations[idx] >= h;
    }
}