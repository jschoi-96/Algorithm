class Solution {
    // 각 길이 10만

    // 1. grid 전체 값을 1차원 배열로 변환
    // 2. sort후 median값을 찾음
    // 3. 해당 median값을 통해 최소 연산값을 이분탐색으로 구함.
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int [] arr = new int[n*m];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int len = arr.length;
        int median = arr[len / 2];

        // System.out.println(calculate(arr, median, x));

        return calculate(arr, median, x);   
    }

    public int calculate(int[] arr, int median, int x) {
        int cnt = 0;
        for(int num : arr) {
            if (num == median) continue; // 목표 값과 동일하다면 연산 x

            if (Math.abs(num - median) %  x != 0) return -1;
            cnt += Math.abs(num - median) / x;
        }
        return cnt;
    }
}