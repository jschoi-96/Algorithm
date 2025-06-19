import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check();
        check2();
        check3();
        check4();
        check5();
        System.out.println(max);
    }

    public static void check() {
        // I 모양 - 가로
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= m - 4; j++) {
                int sum = board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3];
                max = Math.max(max, sum);
            }
        }

        // I 모양 - 세로
        for(int i = 0; i <= n - 4; i++) {
            for(int j = 0; j < m; j++) {
                int sum = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j];
                max = Math.max(max, sum);
            }
        }
    }

    public static void check2() {
        // O 모양 (정사각형)
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1];
                max = Math.max(max, sum);
            }
        }
    }

    public static void check3() {
        // L 모양 8가지 케이스

        // L 모양 1: ㄱ
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+2][j+1];
                max = Math.max(max, sum);
            }
        }

        // L 모양 2: ㄱ 뒤집기
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j+1];
                max = Math.max(max, sum);
            }
        }

        // L 모양 3: ㄴ
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j+1] + board[i+1][j+1] + board[i+2][j+1] + board[i+2][j];
                max = Math.max(max, sum);
            }
        }

        // L 모양 4: ㄴ 뒤집기
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i][j+1] + board[i+1][j] + board[i+2][j];
                max = Math.max(max, sum);
            }
        }

        // L 모양 5: └
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
                max = Math.max(max, sum);
            }
        }

        // L 모양 6: ┌
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j];
                max = Math.max(max, sum);
            }
        }

        // L 모양 7: ┐
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+2];
                max = Math.max(max, sum);
            }
        }

        // L 모양 8: ┘
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j+2] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
                max = Math.max(max, sum);
            }
        }
    }

    public static void check4() {
        // Z 모양 4가지 케이스

        // Z 모양 1
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
                max = Math.max(max, sum);
            }
        }

        // Z 모양 2 (1번 대칭)
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j+1] + board[i+1][j+1] + board[i+1][j] + board[i+2][j];
                max = Math.max(max, sum);
            }
        }

        // Z 모양 3 (90도 회전)
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j+2];
                max = Math.max(max, sum);
            }
        }

        // Z 모양 4 (3번 대칭)
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j+1] + board[i][j+2] + board[i+1][j] + board[i+1][j+1];
                max = Math.max(max, sum);
            }
        }
    }

    public static void check5() {
        // T 모양 4가지 케이스

        // T 모양 1: ㅗ
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j+1];
                max = Math.max(max, sum);
            }
        }

        // T 모양 2: ㅜ
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                int sum = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+1][j+2];
                max = Math.max(max, sum);
            }
        }

        // T 모양 3: ㅏ
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j];
                max = Math.max(max, sum);
            }
        }

        // T 모양 4: ㅓ
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                int sum = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+2][j+1];
                max = Math.max(max, sum);
            }
        }
    }
}