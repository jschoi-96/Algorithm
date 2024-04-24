import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean [] visited = new boolean[10];
    public int solution(String numbers) {
        
        for(int i = 0; i < numbers.length(); i++){
            recur("", numbers, i+1);
        }
        return set.size();
    }
    
    private void recur(String tmp, String numbers, int depth) {
         if (!tmp.isEmpty() && tmp.length() == depth) {
            int number = Integer.parseInt(tmp);
            if (isPrime(number)) {
                set.add(number);
                return;
            }
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if (!visited[i]) {
                char c = numbers.charAt(i);
                visited[i] = true;
                recur(tmp + String.valueOf(c), numbers, depth);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}