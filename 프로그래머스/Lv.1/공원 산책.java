import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int posX = -1;
        int posY = -1;
        int rowLen = park.length;
        int colLen = park[0].length();

        // 시작 지점 좌표 찾기
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (park[i].charAt(j) == 'S') {
                    posX = i;
                    posY = j;
                }
            }
        }

        // 방향에 따른 좌표 이동값 저장
        Map<Character, List<Integer>> dirMap = Map.of('E', List.of(0, 1), 'W', List.of(0, -1), 'S', List.of(1, 0), 'N', List.of(-1, 0));

        for (String route : routes) {
            char direction = route.charAt(0);
            int distance = route.charAt(2) - '0';

            int defaultX = posX;
            int defaultY = posY;

            // 주어진 거리만큼 이동
            for (int i = 0; i < distance; i++) {
                int moveX = posX + dirMap.get(direction).get(0);
                int moveY = posY + dirMap.get(direction).get(1);

                // 범위를 벗어나거나 장애물을 만나면 기본 위치로 돌아감
                if (isOutOfRange(moveX, moveY, rowLen, colLen) || park[moveX].charAt(moveY) == 'X') {
                    posX = defaultX;
                    posY = defaultY;
                    break;
                }

                posX = moveX;
                posY = moveY;
            }
        }

        answer[0] = posX;
        answer[1] = posY;
        return answer;
    }

    // 범위를 벗어나는지 확인
    private boolean isOutOfRange(int x, int y, int rowLen, int colLen) {
        return x < 0 || x >= rowLen || y < 0 || y >= colLen;
    }
}
