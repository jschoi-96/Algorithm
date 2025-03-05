class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int hi = 0;
        for(int diff : diffs) hi = Math.max(hi, diff);
        int lo = 1;
        
        while(lo < hi) {
            int level = (lo + hi) / 2;
            long sum = 0;
            
            for(int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) sum += times[i];
                else {
                    int minus = diffs[i] - level;
                    sum += (times[i] + times[i-1]) * minus + times[i];
                }
                
                if (sum > limit) break;
            }
            
            if (sum > limit) lo = level + 1;
            else hi = level;
        }
        return lo;
    }
}