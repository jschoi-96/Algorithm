import java.util.*;
class Solution {
    int [] arr;
    int [] rate = {10, 20, 30, 40};
    
    int max_cnt = 0;
    int max_price = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        arr = new int[emoticons.length];
        dfs(0, emoticons, users);
        
        answer[0] = max_cnt;
        answer[1] = max_price;
        // System.out.println("max: " + max_cnt + " " + max_price);
        return answer;
    }
    
    public void dfs(int depth, int[] emoticons, int[][] users) {
        if (depth == emoticons.length) {
            
            check(arr, emoticons, users); // 할인 비율에 따른 가격을 체크한다.
            
            for(int i = 0; i < arr.length; i++) {
                //System.out.print(arr[i] + " ");
            }
            //System.out.println();
            return;
        }
        
        // 모든 할인률의 경우의 수를 구한다. 최악의 경우 4^7이므로 백트래킹 가능
        for(int i = 0; i < rate.length; i++) {
            arr[depth] = rate[i];
            dfs(depth + 1, emoticons, users);
        }
    }
    
    public void check(int[] arr, int[] emoticons, int[][] users) {
        
        int total = 0;
        int cnt = 0; // 이모티콘 플러스 가입 수
        for(int i = 0; i < users.length; i++) {
            int a = users[i][0]; // 비율
            int b = users[i][1]; // 사용자가 소지한 가격
            
            int limit = 0; // 일정 금액을 넘는지 체크하는 변수
            for(int j = 0; j < arr.length; j++) {
                // 할인률이 이상이라면 이모티콘을 모두 구매해야함
                if (arr[j] >= a) {
                    int price = emoticons[j] * (100 - arr[j]) / 100;
                    limit += price;
                }
                
                if (limit >= b) { // 소지한 가격을 넘는 경우 이모티콘 플러스 서비스를 가입
                    limit = 0;
                    cnt++;
                    break;
                }
            }
            total += limit;
        }
        
        if (cnt >= max_cnt) {
            
            if (cnt > max_cnt) max_price = 0;
            max_cnt = cnt;
            max_price = Math.max(max_price, total);
        }
        //System.out.println(total + " " + cnt);
    }
}