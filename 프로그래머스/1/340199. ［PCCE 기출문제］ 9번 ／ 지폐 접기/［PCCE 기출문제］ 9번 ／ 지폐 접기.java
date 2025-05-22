class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(true) {
            if (isHalf(wallet, bill) || isTurn(wallet, bill)) {
                break;
            }
            
            if (bill[0] > bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
                        
            answer++;
        }
        return answer;
    }
    
    public boolean isHalf(int[] wallet, int[] bill) {
        return bill[0] <= wallet[0] && bill[1] <= wallet[1];
    }
    
    public boolean isTurn(int[] wallet, int[] bill) {
        return bill[1] <= wallet[0] && bill[0] <= wallet[1];
    }
}