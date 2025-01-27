class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        Arrays.sort(piles);

        long lo = 1, hi = piles[n-1];

        while(lo < hi) {
            long mid = (lo + hi) / 2;

            long res = 0;
            for(int pile : piles) {
                if (pile % mid == 0) res += (pile / mid);
                else res += (pile / mid) + 1;
            }

            // System.out.println(lo);
            if (res > h) lo = mid + 1;
            else hi = mid;
        }
        return (int)lo;
    }
}