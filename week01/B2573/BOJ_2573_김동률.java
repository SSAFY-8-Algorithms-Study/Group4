import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2573 {
	static int[][] arr1;
	static int[][] arr2;
	static boolean[][] visited;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int N;
	static int M;
	static int count;
	static boolean check;
	// Baekjoon 2573 빙산
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		arr1 = new int[N][M];
		arr2 = new int[N][M];

		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				arr1[i][j] = Integer.parseInt(str[j]);
			}
		}// end input

		int time = 0;
		while(true) {
			time++;
			year();
			
			visited = new boolean[N][M];
			count = 0;
			//dfs
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if(arr1[a][b] != 0 && visited[a][b] != true) {
						dfs(a,b);
						count++;
					}
				}
			}
			if(count >= 2) {
				break;
			}
			if(allZero()) {
				time = 0;
				break;
			}

		}
		System.out.println(time);
	}
	static void dfs(int a, int b) {
		int nowi=0, nowj=0;
		int nexti=0, nextj=0;
		
		//dfs
		nowi = a;
		nowj = b;
		
		//나 방문했어~
		visited[a][b] = true;
		//System.out.println(a + "," + b);
		
		for(int k=0; k<4; k++) {
			nexti = nowi + di[k];
			nextj = nowj + dj[k];
			
			//재귀 dfs
			if(nexti < 0 || nextj < 0 || nexti >= N || nextj >= M || visited[nexti][nextj] == true || arr1[nexti][nextj] == 0) {
				
			}else {
				dfs(nexti, nextj);
			}
		}
	}
	static void year() {
		int nowi=0, nowj=0;
		int nexti=0, nextj=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr1[i][j] == 0) {
					arr2[i][j] = 0;
				}else {
					nowi = i;
					nowj = j;
					
					int iceCnt = 0;
					//얼음 주변 델타 탐색 - 0의 갯수 세기
					for(int k=0; k<4; k++) {
						nexti = nowi + di[k];
						nextj = nowj + dj[k];
						if(nexti < 0 || nextj < 0 || nexti > N || nextj > M || arr1[nexti][nextj] != 0) {
							continue;
						}else {
							iceCnt++;
						}
					}
					if(arr1[i][j] - iceCnt < 0) {
						arr2[i][j] = 0;
					}else {
						arr2[i][j] = arr1[i][j] - iceCnt;
					}
				}
			}
		}
		//System.out.println("--------------------------------------------------------------------");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr1[i][j] = arr2[i][j];
				//System.out.print(arr2[i][j] + " ");
			}
			//System.out.println();
		}
	}
	static boolean allZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr1[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
}

