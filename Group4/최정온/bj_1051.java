package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj_1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];

		String temp = "";

		int size = 1;

		int maxValue = Math.min(N, M);
		if (N == 1 || M == 1) {
			System.out.println(size);
		} else {
			for (int i = 0; i < N; i++) {
				temp = br.readLine();
				for (int j = 0; j < M; j++) {
					board[i][j] = temp.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int l = 0; l < maxValue; l++) {
						if (i + l < N && j + l < M) {
							if (board[i][j] == board[i][j + l] && board[i][j] == board[i + l][j]
									&& board[i][j] == board[i + l][j + l]) {
								int temp_size = (l + 1) * (l + 1);
								size = Math.max(size, temp_size);
							}
						}
					}
				}
			}
			System.out.println(size);
		}
	}
}

//기존 풀이 	
//public class bj_1051 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//
//		int[][] board = new int[N][M];
//
//		String temp = "";
//
//		int size = 1;
//
//		int maxValue = Math.min(N, M);
//		if (N == 1 || M == 1) {
//			System.out.println(size);
//		} else {
//			for (int i = 0; i < N; i++) {
//				temp = br.readLine();
//				for (int j = 0; j < M; j++) {
//					board[i][j] = temp.charAt(j) - '0';
//				}
//			}
//
//				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						for (int l = 0; l < maxValue; l++) {
//							int[][] test_board = new int[l][l];
//
//						for (int col = 0; col < test_board.length; col++) {
//							for (int row = 0; row < test_board.length; row++) {
//								if ((i + col) >= 0 && (j + row) >= 0 && (i + col) < maxValue && (j + row) < maxValue) {
//									System.out.println("i + col: " + (i + col));
//									System.out.println("j + row: " + (j + row));
//									test_board[col][row] = board[(i + col)][(j + row)];
//								}
//							}
//						}
//
//						if (test_board[0][0] == test_board[0][test_board.length - 1]
//								&& test_board[0][0] == test_board[test_board.length - 1][0]
//								&& test_board[0][0] == test_board[test_board.length - 1][test_board.length - 1]) {
//							size = Math.max(size, test_board.length * test_board.length);
//						}
//
//						for (int k = 0; k < test_board.length; k++) {
//							for (int t = 0; t < test_board.length; t++) {
//								System.out.print(test_board[k][t]);
//							}
//							System.out.println();
//						}
//
//						System.out.println("///////////////////");
//
//					}
//				}
//			}
//
////		for (int i = 0; i < N; i++) {
////			for (int j = 0; j < M; j++) {
////				System.out.print(board[i][j]);
////			}
////			System.out.println();
////		}
//			System.out.println(size);
//		}
//	}
//}
