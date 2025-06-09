import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] board = new int[102][102];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row = 3, col = 3;
        int time = 0;
        while (time <= 100) {
            if (board[r-1][c-1] == k) {
                System.out.println(time);
                return;
            }

            if (row >= col) {
                int[][] newBoard = new int[102][102];
                int maxCol = 0;
                for(int i = 0; i < row; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for(int j = 0; j < col; j++) {
                        int val = board[i][j];
                        if (val == 0) continue;
                        map.put(val, map.getOrDefault(val, 0) + 1);
                    }

                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                        if (a[1] == b[1]) {
                            return a[0] - b[0];
                        }
                        return a[1] - b[1];
                    });

                    for(Integer key : map.keySet()) pq.add(new int[]{key, map.get(key)});
                    int idx = 0;
                    while(!pq.isEmpty() && idx < 100) {
                        int[] cur = pq.poll();
                        newBoard[i][idx++] = cur[0];
                        newBoard[i][idx++] = cur[1];
                    }
                    maxCol = Math.max(maxCol, idx);
                }
                col = maxCol;
                board = newBoard;
            }

            else {
                int[][] newBoard = new int[102][102];
                int maxRow = 0;
                for(int i = 0; i < col; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for(int j = 0; j < row; j++) {
                        int val = board[j][i];
                        if (val == 0) continue;
                        map.put(val, map.getOrDefault(val, 0) + 1);
                    }

                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                        if (a[1] == b[1]) {
                            return a[0] - b[0];
                        }
                        return a[1] - b[1];
                    });

                    for(Integer key : map.keySet()) pq.add(new int[]{key, map.get(key)});
                    int idx = 0;
                    while(!pq.isEmpty() && idx < 100) {
                        int[] cur = pq.poll();
                        newBoard[idx++][i] = cur[0];
                        newBoard[idx++][i] = cur[1];
                    }
                    maxRow = Math.max(maxRow, idx);
                }
                row = maxRow;
                board = newBoard;
            }
            time++;
        }

        System.out.println(-1);
    }
}
