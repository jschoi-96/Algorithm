import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        
        Arrays.sort(book_time, (a,b) -> Integer.compare(convert(a[0]), convert(b[0])));
        
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        
        int [] before = new int[]{0,0};
        for (String [] book : book_time) {
            String s1 = book[0];
            String s2 = book[1];
            int start = convert(s1);
            int end = convert(s2) + 10;
            
            if (pq.isEmpty()) {
                pq.add(new int[]{start, end});
                before[0] = start;
                before[1] = end;
                continue;
            }
            
            //int [] cur = pq.poll();
            if (start >= pq.peek()[1]) { // 현재 입실 시간이 퇴실 시간보다 느린경우
                pq.poll();
                pq.add(new int[]{start, end});
            }

            else {
                answer++;
                pq.add(new int[]{start, end});
                //pq.add(cur);
            }
            
        }
        
        return answer;
    }
    
    public int convert(String time) {
        String [] str = time.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}