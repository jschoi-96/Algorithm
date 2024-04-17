class Solution {
    public int solution(String s) {
        String [] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i = 0; i < numbers.length; i++){
            if (s.contains(numbers[i])) {
                s = s.replace(numbers[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }
}