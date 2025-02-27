import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        
        int [] arr1 = new int[10002];
        int [] arr2 = new int[10002];
        
        int count2 = 0;
        for(int i = 0; i < n; i++) {
            arr2[topping[i]]++;
            if (arr2[topping[i]] == 1) count2++;
        }
        
        int count1 = 0;
        for(int i = 0; i < n; i++) {
            arr1[topping[i]]++;
            if (arr1[topping[i]] == 1) count1++;
            arr2[topping[i]]--;
            if (arr2[topping[i]] == 0) count2--;
            
            if (count1 == count2) {
                answer++;
            }
        }
        
        return answer;
    }
}