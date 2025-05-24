import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] wheels = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++) {
            String input = br.readLine();
            for(int j = 0; j < 8; j++) {
                wheels[i][j] = input.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            num -= 1;
            int[] directions = new int[4];
            directions[num] = dir;

            for (int j = num; j > 0; j--) { // 왼쪽
                if (wheels[j][6] == wheels[j-1][2]) break;
                else {
                    directions[j-1] = directions[j] * -1;
                }
            }

            for(int j = num; j <= 2; j++) {
                if (wheels[j][2] == wheels[j+1][6]) break;
                else {
                    directions[j+1] = directions[j] * -1;
                }
            }

            for(int j = 0; j < 4; j++) {
                if (directions[j] == 1) wheels[j] = moveFront(wheels[j]);
                else if (directions[j] == -1) wheels[j] = moveBack(wheels[j]);
            }

//            for(int j = 0; j < 4; j++) {
//                System.out.print(directions[j] + " ");
//                for(int t = 0; t < 8; t++) {
//                    System.out.print(wheels[j][t]);
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        System.out.println(getScore());
    }

    public static int getScore() {
        int score = 0;
        if (wheels[0][0] == 1) score += 1;
        if (wheels[1][0] == 1) score += 2;
        if (wheels[2][0] == 1) score += 4;
        if (wheels[3][0] == 1) score += 8;
        return score;
    }

    public static int[] moveFront(int[] arr) {
        int[] tmp = new int[8];
        for(int i = 1; i < 8; i++) {
            tmp[i] = arr[i-1];
        }
        tmp[0] = arr[7];
        return tmp;
    }

    public static int[] moveBack(int[] arr) {
        int[] tmp = new int[8];
        for(int i = 0; i < 7; i++) {
            tmp[i] = arr[i + 1];
        }
        tmp[7] = arr[0];
        return tmp;
    }
}
