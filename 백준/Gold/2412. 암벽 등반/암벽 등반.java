import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static ArrayList<Pos>[] rock;
    static Set<String> visited = new HashSet<>(); // 좌표 방문 여부를 저장

    public static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 암벽에 박힌 홈 개수
        T = Integer.parseInt(st.nextToken()); // 정상 위치 (y)

        rock = new ArrayList[200001]; // 최대 y값: 200,000
        for (int i = 0; i <= 200000; i++) {
            rock[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            rock[y].add(new Pos(x, y));
        }

        // 각 y값에서 x값을 오름차순으로 정렬
        for (int i = 0; i <= 200000; i++) {
            rock[i].sort(Comparator.comparingInt(pos -> pos.x));
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));  // 시작점 (0, 0)
        visited.add("0,0");    // 시작점 방문 처리

        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pos now = q.poll();

                if (now.y == T) {
                    return ans; 
                }

                for (int y = now.y - 2; y <= now.y + 2; y++) {
                    if (y < 0 || y > 200000) continue;

                    for (int xIndex = 0; xIndex < rock[y].size(); xIndex++) {
                        Pos next = rock[y].get(xIndex);
                        int x = next.x;

                        if (now.x + 2 < x) break; // x 값이 너무 크면 더 볼 필요 없음
                        if (Math.abs(now.x - x) <= 2 && !visited.contains(x + "," + y)) {
                            q.add(new Pos(x, y));
                            visited.add(x + "," + y); // 방문 처리
                            rock[y].remove(xIndex); // 암벽 제거
                            xIndex--; // remove 후 인덱스 조정
                        }
                    }
                }
            }
            ans++;
        }

        return -1; // 목표 위치에 도달할 수 없는 경우
    }
}
