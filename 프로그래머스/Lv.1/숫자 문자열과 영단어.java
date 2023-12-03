import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String [] engs = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i = 0; i < engs.length; i++){
            s = s.replaceAll(engs[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
