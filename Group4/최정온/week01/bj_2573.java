package gold;

import java.util.Scanner;

public class bj_2573 {
	static boolean dfs(int[][] next_board, int i, int j) {
		//물에 안잠긴지 체크
		if(next_board[i][j] == 1) {
			next_board[i][j] = 0;
            //up
            dfs(next_board, i-1, j);
            //right
            dfs(next_board, i, j+1);
            //down
            dfs(next_board, i+1, j);
            //left
            dfs(next_board, i, j-1);
            return true;
		}

		return false;
	}
	
//	static boolean dfs(int[][] next_board, int i, int j) {
//		int[][] temp_board = new int[N][M];
//		
//		for (int x = 0; x < N; x++) {
//			for (int y = 0; y < M; y++) {
//				temp_board[x][y] = next_board[x][y];
//			}
//		}
//		
//		//물에 안잠긴지 체크
//		if(temp_board[i][j] == 1) {
//			temp_board[i][j] = 0;
//            //up
//            dfs(temp_board, i-1, j);
//            //right
//            dfs(temp_board, i, j+1);
//            //down
//            dfs(temp_board, i+1, j);
//            //left
//            dfs(temp_board, i, j-1);
//            return true;
//		}
//
//		return false;
//	}

	// 이차원 배열을 받아서 다음 년에 들어올 값을 계산
	static int searchDelta(int[][] board, int i, int j) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// 0의 갯수 확인
		int zero_count = 0;

		// 4방향 탐색
		for (int index = 0; index < 4; index++) {
			int next_x = i + dx[index];
			int next_y = j + dy[index];

			if (board[next_x][next_y] == 0) {
				zero_count++;
			}
		}

		return zero_count;
	}
	
	static void print(int[][] next_board) {
		for (int j = 0; j < next_board.length; j++) {
			for (int k = 0; k < next_board[0].length; k++) {
				System.out.print(next_board[j][k]);
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		// 여기까지 입력
		int time = 0;

		while (true) {
			time++;
			// 기본 0으로 초기화
			int[][] next_board = new int[N][M];
			int[][] temp_board = new int[N][M];

			// 다음 년도 보드 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 0이 아닐때만 돌기(예외 처리 안하기 위해)
					if (board[i][j] != 0) {
						int next_value = (board[i][j] - searchDelta(board, i, j)) < 0 ? 0
								: board[i][j] - searchDelta(board, i, j);
						temp_board[i][j] = next_value;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					next_board[i][j] = temp_board[i][j];
					board[i][j] = temp_board[i][j];
				}
			}

			boolean allZero = true;
//			print(next_board);

			// next_board 변환해주기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (next_board[i][j] != 0) {
						allZero = false;
						next_board[i][j] = 1;
					}
				}
			}
//			print(next_board);

			int result = 0;
			// 영역 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//1인 경우에만 실행
					if (next_board[i][j] != 0) {
//						print(next_board);
						if (dfs(next_board, i, j)) {
							result++;
						}
					}
				}
			}
			
			if (result >= 2) {
				break;
			}
			
			// 탈출 조건 1
			if (allZero) {
				time = 0;
				break;
			}
		}
		System.out.println(time);
	}
}
