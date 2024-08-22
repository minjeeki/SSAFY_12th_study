package swea;

import java.util.*;
import java.io.*;

public class SWEA_4014 {
    // 4014. Ȱ�ַ� �Ǽ�

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            int[][] transposedMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    transposedMap[j][i] = map[i][j];
                }
            }

            int count = 0;

            // Ȱ�ַ� �������� üũ -��
            count += countRunways(map, N, X);
            // Ȱ�ַ� �������� üũ - ��
            count += countRunways(transposedMap, N, X);

            System.out.println("#" + tc + " " + count);
        }
    }

   

    // Ȱ�ַ� ���� ���� üũ
    private static int countRunways(int[][] map, int N, int X) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isPossible(map, i, N, X)) {
                count++;
            }
        }
        return count;
    }

    // Ȱ�ַ� ���� ���� �˻�
    private static boolean isPossible(int[][] map, int index, int N, int X) {
        int cnt = 1;
        boolean down = false;

        for (int j = 1; j < N; j++) {
            int currentHeight = map[index][j];
            int previousHeight = map[index][j - 1];

            if (previousHeight == currentHeight) {
                cnt++;
            } else if (previousHeight + 1 == currentHeight) { // ������
                if (!canPlaceSlope(down, cnt, X)) return false;
                down = false;
                cnt = 1;
            } else if (previousHeight - 1 == currentHeight) { // ������
                if (down && cnt < X) return false;
                down = true;
                cnt = 1;
            } else {
                return false; // ���� ���̰� 1�� �ƴϸ� false
            }
        }

        return !down || (down && cnt >= X);
    }

    // ���� ���Ƶ� �Ǵ��� Ȯ��
    private static boolean canPlaceSlope(boolean down, int cnt, int X) {
        return !(down && cnt < X) && !(cnt < X);
    }
}

