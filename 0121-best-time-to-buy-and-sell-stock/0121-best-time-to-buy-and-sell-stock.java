class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int l = 0, r = 1;
        int max_res = 0;
        while(r < n) {
            if (prices[l] < prices[r]) {
                max_res = Math.max(max_res, prices[r] - prices[l]);
                //System.out.println(prices[r] - prices[l]);
            }
            else l = r;

            r++;
        }
        return max_res;
    }
}