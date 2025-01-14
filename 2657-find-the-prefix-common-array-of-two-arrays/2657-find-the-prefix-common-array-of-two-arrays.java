class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        List<Integer> common = new ArrayList<>();

        int [] res = new int[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {

            if (A[i] == B[i]) {
                cnt++;
                common.add(A[i]);
            }

            else {
                if (common.contains(A[i])) cnt++;
                if (common.contains(B[i])) cnt++;
                common.add(A[i]);
                common.add(B[i]);
            }

            res[i] = cnt;
            System.out.println(cnt);
        }

        return res;
    }
}