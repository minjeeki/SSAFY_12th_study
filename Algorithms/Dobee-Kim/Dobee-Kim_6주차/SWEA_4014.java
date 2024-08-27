package DobeeKim_6����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014 {
	static int map[][], N, X, cnt;
	static boolean Installed[];
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			makeAirway();
			System.out.println("#"+tc+" "+cnt);
		}
		
	}

	private static void makeAirway() {
		
		// ���� üũ
		for (int i = 0; i < N; i++) {
			boolean lineFail = false;
			Installed = new boolean[N];
			int idx = 1;
			outer : 
			while (idx<N) {
				// ��
				int left = map[i][idx-1];
				int right = map[i][idx];
				int comp = left - right;
				switch (comp){
					case 1 : //Ȱ�ַ� +����
						for (int k = idx; k < idx+X ; k++) {
							// �������� ����ų�, ���̸�ŭ ���� ���� �ʰų�, ��ġ�� �Ͱ� ��ĥ ��
							if (k < 0 || k >= N || right != map[i][k] || Installed[k] == true) {
								lineFail = true;
								break outer;
							}
						}
						// Ȱ�ַ� ��ġ
						for (int k = idx+1; k < idx+X ; k++) {
							Installed[k] = true;
						}
						idx = idx+X;
					break;	
					case -1 : //Ȱ�ַ� -����
						for (int k = idx-1; k >= idx-X ; k--) {
							// �������� ����ų�, ���̸�ŭ ���� ���� �ʰų�, ��ġ�� �Ͱ� ��ĥ ��
							if (k < 0 || k >= N || left != map[i][k] || Installed[k] == true) {
								lineFail = true;
								break outer;
							}
						}
						
						// Ȱ�ַ� ��ġ
						for (int k = idx-1; k >= idx-X ; k--) {
							Installed[k] = true;
						}
						idx++;
					break;
					case 0 : // ���� ����
						idx++;
					break;
					default:
						lineFail = true;
					break outer;
				}
			}
			if(!lineFail) cnt++;
		}
		
		// ���� üũ
		for (int i = 0; i < N; i++) {
			boolean lineFail = false;
			Installed = new boolean[N];
			int idx = 1;
			outer : 
			while (idx<N) {
				// ��
				int left = map[idx-1][i];
				int right = map[idx][i];
				int comp = left - right;
				switch (comp){
					case 1 : //Ȱ�ַ� +����
						for (int k = idx; k < idx+X ; k++) {
							// �������� ����ų�, ���̸�ŭ ���� ���� �ʰų�, ��ġ�� �Ͱ� ��ĥ ��
							if (k < 0 || k >= N || right != map[k][i] || Installed[k] == true) {
								lineFail = true;
								break outer;
							}
						}
						// Ȱ�ַ� ��ġ
						for (int k = idx+1; k < idx+X ; k++) {
							Installed[k] = true;
						}
						idx = idx+X;
					break;	
					case -1 : //Ȱ�ַ� -����
						for (int k = idx-1; k >= idx-X ; k--) {
							// �������� ����ų�, ���̸�ŭ ���� ���� �ʰų�, ��ġ�� �Ͱ� ��ĥ ��
							if (k < 0 || k >= N || left != map[k][i] || Installed[k] == true) {
								lineFail = true;
								break outer;
							}
						}
						// Ȱ�ַ� ��ġ
						for (int k = idx-1; k >= idx-X ; k--) {
							Installed[k] = true;
						}
						idx++;
					break;
					case 0 : // ���� ����
						idx++;
					break;
					default:
						lineFail = true;
					break outer;
				}
			}
			if(!lineFail) cnt++;
		}
	}
}
