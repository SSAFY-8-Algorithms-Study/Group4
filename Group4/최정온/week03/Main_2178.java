package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
	
	static int N;
	static int M;
	
	static int[][] board;
//	static int[][] copyBoard;
	
	static final int[] dx = {-1, 0, +1, 0}; //up, right, down, left
	static final int[] dy = {0, +1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
//		copyBoard = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
//				copyBoard[i][j] = board[i][j];
			}
		}
		//Input End
		
//		for(int[] line : board) {
//			System.out.println(Arrays.toString(line));
//		}
		
		bfs();
		
		//output
		System.out.println(board[N-1][M-1]);
	}
	
	static void print() {
		for(int[] list :  board) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println("-------------------------------");
	}
	
	
	static void bfs() {
		 Queue<Position> queue = new LinkedList<Position>();
		 queue.offer(new Position(0,0,1));
		 
		 while(!queue.isEmpty()) {
			 Position currentPosition = queue.poll();
			 	int x = currentPosition.x;
			 	int y = currentPosition.y;
			 	int count = currentPosition.count;
			 
			 
				for (int direct = 0; direct < 4; direct++) {
					int nextX = x + dx[direct];
					int nextY = y + dy[direct];
					
					//범위 벗어나는지 체크
					if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
						continue;
					}
					
					//이미 방문한 곳으로 돌아갈 수 없음
					if(board[nextX][nextY] > 1) {
						continue;
					}
					
					//0인곳에는 못감
					if(board[nextX][nextY] == 0) {
						continue;
					}
					
//					System.out.println("cnt= " + currentPosition.count);
//					print();
					
					queue.offer(new Position(nextX, nextY, (count+1)));
					//방문 표시
					board[nextX][nextY] = count+1;
				}
		 }
		 
	}
	
	static class Position{
		int x;
		int y;
		int count;
		
		public Position(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
