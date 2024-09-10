package swea;

import java.util.*;
import java.io.*;

public class SWEA_4014 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int X = Integer.parseInt(st.nextToken()); 
            
            int[][] map = new int[N][N]; // 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) 
                    map[i][j] = Integer.parseInt(st.nextToken()); 
            }
            
            int runwayCount = 0; // ������ Ȱ�ַ� ��
            
            // ��
            next: for (int i = 0; i < N; i++) {
                int cnt = 1; // ���ӵ� ������ ����
                boolean down = false; // ���� ���������� Ȯ��
                
                for (int j = 1; j < N; j++) {
                    if (map[i][j - 1] == map[i][j]) 
                        cnt++; // ���̰� ������ ī��Ʈ ����
                    else if (map[i][j - 1] + 1 == map[i][j]) { // ������
                        if (down && cnt < 2 * X) continue next; // ������ �� ���� �ʿ�
                        if (!down && cnt < X) continue next; // ������ ���� �ʿ�
                        down = false; // ������ �ƴ�
                        cnt = 1; // �� ���� ����
                    } else if (map[i][j - 1] - 1 == map[i][j]) { // ������
                        if (down && cnt < X) continue next; // ������ �� ���� �ʿ�
                        down = true; // ���������� ����
                        cnt = 1; // �� ���� ����
                    } else {
                        continue next; // ���� ���̰� 1�� �ƴ� ���
                    }
                }
                
                // ������ ���� üũ
                if (!down || (down && cnt >= X)) 
                    runwayCount++; // Ȱ�ַ� ����
            }
            
            // ��
            next: for (int i = 0; i < N; i++) {
                int cnt = 1; // ���ӵ� ������ ����
                boolean down = false; // ���� ���������� Ȯ��
                
                for (int j = 1; j < N; j++) {
                    if (map[j - 1][i] == map[j][i]) 
                        cnt++; // ���̰� ������ ī��Ʈ ����
                    else if (map[j - 1][i] + 1 == map[j][i]) { // ������
                        if (down && cnt < 2 * X) continue next; // ������ �� ���� �ʿ�
                        if (!down && cnt < X) continue next; // ������ ���� �ʿ�
                        down = false; // ������ �ƴ�
                        cnt = 1; // �� ���� ����
                    } else if (map[j - 1][i] - 1 == map[j][i]) { // ������
                        if (down && cnt < X) continue next; // ������ �� ���� �ʿ�
                        down = true; // ���������� ����
                        cnt = 1; // �� ���� ����
                    } else {
                        continue next; // ���� ���̰� 1�� �ƴ� ���
                    }
                }
                
                // ������ ���� üũ
                if (!down || (down && cnt >= X)) 
                    runwayCount++;
            }
            
            System.out.println("#" + t + " " + runwayCount);
        }
    }
}
