import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        
        int [] arr = new int[n+1];
        for(int i = 0; i <= n; i++) {
            arr[i] = elements[i % n];
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= n; i++) { // 1 ~ n까지의 길이
            for(int j = 0; j < n; j++) { // 시작 위치 
                int sum = 0;
                for(int k = 0; k < i; k++) {
                    sum += arr[(j + k) % n];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}