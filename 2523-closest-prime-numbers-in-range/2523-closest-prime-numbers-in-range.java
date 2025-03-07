class Solution {
    // 100만 
    boolean [] isPrime;
    public int[] closestPrimes(int left, int right) {
        isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(right); i++) {
            if (isPrime[i]) { // 소수라면, 배수들을 모두 false 처리
                for(int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for(int i = left; i <= right; i++) {

            if (isPrime[i]) {
                tmp.add(i);
            }

            if (tmp.size() == 2) {
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }

        if (res.size() == 0) return new int[]{-1, -1};


        int min_diff = Integer.MAX_VALUE;
        int [] ans = new int[2];
        for(List<Integer> list : res) {
            int diff = list.get(1) - list.get(0);
            if (diff < min_diff) {
                min_diff = diff;
                ans[0] = list.get(0);
                ans[1] = list.get(1);
            }
        }

        return ans;
    }
}