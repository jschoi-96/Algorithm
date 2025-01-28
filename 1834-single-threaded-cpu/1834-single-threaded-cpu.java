class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int [] res = new int[n];
        int [][] tmp = new int[n][3];

        for(int i = 0; i < n; i++) {
            tmp[i][0] = tasks[i][0];
            tmp[i][1] = tasks[i][1];
            tmp[i][2] = i;
        }

        // enqueue 시간 순서대로 정렬
        Arrays.sort(tmp, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) { // process가 같다면 index 순서
                return Integer.compare(a[2], b[2]);
            };
            return Integer.compare(a[1], b[1]);
        });

        int idx = 0;
        int time = 0;
        int tmpIdx = 0;
        while(idx < n) {
            while(tmpIdx < n && tmp[tmpIdx][0] <= time) {
                pq.add(tmp[tmpIdx]);
                tmpIdx++;
                // System.out.println("??");
            }

            if (pq.isEmpty()) {
                time = tmp[tmpIdx][0]; // 다음 작업의 enqueue 시간으로 이동
            }

            else {
                int [] cur = pq.poll();
                res[idx++] = cur[2];
                time += cur[1];
            }
        }
        return res;
    }
}