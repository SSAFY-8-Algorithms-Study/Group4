import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[][] visit;
	static Point[] virusArr;
	static int N;
	static int M;
	static Queue<Point> q;
	static int normal = 0;
	static int virusCnt = 0;
	static List<Point> virusList = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();	// 바이러스 세개 뽑아서 활성화~
		
		arr = new int[N][N];

		virusArr = new Point[M];
		
		for(int i=0; i<N; i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2) {
					//바이러스 이면~
					virusList.add(new Point(i, j));
					virusCnt++;
				}else if(arr[i][j] == 0) {
					normal++;
				}
			}
		}
		if(normal == 0) {
			System.out.println(0);
		}else {
			comb(0,0);
			if(min == Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(min);
			}
		}
	}
	static void comb(int idx, int cnt) {
		if(cnt == M) {	// M개의 바이러스를 활성화
			q = new LinkedList<>();
			visit = new boolean[N][N];
			int[][] copy = deepcopy(arr);
			
			for(int i=0; i<M; i++) {
				q.add(virusArr[i]);
				
				visit[virusArr[i].i][virusArr[i].j] = true;
			}
			int result = bfs(copy);
			min = Math.min(result, min);
			return;
		}
		
		if(idx == virusCnt) {
			return;
		}
		virusArr[cnt] = virusList.get(idx);
		comb(idx+1, cnt+1);
		comb(idx+1, cnt);
		
	}
	
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	
	static int bfs(int[][] temp) {
		int dayCnt = 0;
		int tempNormal = normal;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point now = q.poll();
				
				for(int d=0; d<4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					
					if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) {
						continue;
					}
					if(visit[nexti][nextj]) {
						continue;
					}
					if(temp[nexti][nextj] == 2) {
						q.add(new Point(nexti, nextj));	//큐에 넣고
						visit[nexti][nextj] = true;		//미리 방문 체크해
					}
					
					if(temp[nexti][nextj] == 0) {
						q.add(new Point(nexti, nextj));	//큐에 넣고
						visit[nexti][nextj] = true;		//미리 방문 체크해
						tempNormal--;		// 비활성 바이러스 활성해
						if(tempNormal == 0) {
							return dayCnt+1;
						}
					}
				}
			}

			dayCnt++;
		}
		return Integer.MAX_VALUE;
	}
	static class Point{
		int i;
		int j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	static int[][] deepcopy(int[][] origin){
		int[][] copy = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
}
