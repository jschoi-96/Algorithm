class Solution {
    // days 10억 meetings 10만
    public int countDays(int days, int[][] meetings) {
        int res = 0;
        Arrays.sort(meetings, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return Integer.compare(a[0], b[0]);
        });
        int st = meetings[0][0];

        int before = 0;
        for(int [] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            if (before != 0 && before + 1 < start) {    
                res += (start - before - 1);
            }

            if (before < end)
                before = end;
        }

        System.out.println(before);
        res += (days - before);
        
        System.out.println("st: " + st);
        if (st > 1) { // 첫 시작이 1일 이상이라면
            res += (st - 1);
        }
        return res;
    }
}