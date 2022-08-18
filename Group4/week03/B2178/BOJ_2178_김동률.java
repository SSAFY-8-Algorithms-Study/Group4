package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178_미로탐색 {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		//print();
		int count = bfs(0,0);
		System.out.println(count);
	}
	static int bfs(int starti, int startj) {
		visited = new boolean[N][M];
		visited[starti][startj] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(starti, startj, 1));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				
				if(nexti >= 0 && nexti <N && nextj >= 0  && nextj < M && map[nexti][nextj] == 1 && visited[nexti][nextj] == false) {
					visited[nexti][nextj] = true;
					
					if(nexti + 1 == N && nextj + 1 == M) {
						return now.count+1;
					}
					queue.add(new Point(nexti, nextj, now.count+1));
					
				}
			}
		}
		return 0;
	}
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class Point{
		int i;
		int j;
		int count;
		Point(int i, int j, int c){
			this.i = i;
			this.j = j;
			this.count = c;
		}
	}
}
