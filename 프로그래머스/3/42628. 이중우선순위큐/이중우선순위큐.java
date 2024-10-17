import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String [] str = op.split(" ");
            int num = Integer.parseInt(str[1]);
            if (str[0].equals("I")) {
                min.add(num);
                max.add(num);
            }
            
            else if (str[0].equals("D")) {

                if (!max.isEmpty() && num == 1) {
                    int c = max.poll();
                    min.remove(c);
                }
                
                else if (!min.isEmpty() && num == -1){
                    int c = min.poll();
                    max.remove(c);
                }
            }
        }
        
        if (min.size() == 0) return new int[]{0,0};
        else if (min.size() == 1) return new int[]{min.peek(), min.peek()};
        else return new int[]{max.peek(), min.peek()};
    }
}