package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16918 {
	static int R;
	static int C;
	static int N;
	
	static char[][] board;
	static int[][] numberBoard;
	static boolean[][] boomCheck;
	
	static final int[] dx = {-1,0,+1,0};
	static final int[] dy = {0,+1,0,-1};
	
	static int time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		numberBoard = new int[R][C];
		boomCheck= new boolean[R][C];		
		time = 0;
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				//폭탄이 들어있는 칸은 3, 빈칸은 -1로 초기화
				if(board[i][j] == 'O') {
					numberBoard[i][j] = 3;
				} else {
					numberBoard[i][j] = -1;
				}
			}
		}
		//Input End
//		System.out.println("time: " + time);
//		printNumberBoard();
		
		for (int t = 0; t < N; t++) {
			time++;
			
			// 빈칸이 아니라면 시간이 지날때마다 숫자가 1씩 사라짐
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(numberBoard[i][j] > 0) {
						numberBoard[i][j]--;
					}
				}
			}
			
			//빈칸에다 폭탄 설치
			if(time == 2) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(numberBoard[i][j] == -1) {
							numberBoard[i][j] = 3;
						}
					}
				}
			}
			
			//폭탄이 터질 곳 예약하기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					//폭탄이 터진다!!
					if(numberBoard[i][j] == 0) {
						boomCheck[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					//폭탄이 터진다!!
					if(boomCheck[i][j] == true) {
						//자기도 빈칸이 된다.
						numberBoard[i][j] = -1;
						for (int d = 0; d < 4; d++) {
							int nextX = i + dx[d];
							int nextY = j + dy[d];
							
							//예외시 건너뛰기
							if(nextX <0 || nextY < 0 || nextX >= R || nextY >= C) {
								continue;
							}
							
							numberBoard[nextX][nextY] = -1;
						}
						
						//폭탄이 터졌으므로 false로 돌려놓자.
						boomCheck[i][j] = false;
					}
				}
			}
			
			
//			System.out.println("time: " + time);
//			printNumberBoard();
			
			if(time >=3) {
				time = 1;
			}
		}
		
		//시간이 모두 흘렀으므로 결과 값 옮겨서 출력하기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(numberBoard[i][j] < 0) {
					board[i][j] = '.';
				} else {
					board[i][j] = 'O';
				}
			}
		}
		
		printBoard();
	}
	
	static void printBoard() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	static void printNumberBoard() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(numberBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
}
