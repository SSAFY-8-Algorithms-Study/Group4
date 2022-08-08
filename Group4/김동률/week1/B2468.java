import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2468 {
	//백준 2468번 안전 영역
	static int[][] arr;
	static boolean[][] bool;
	static int[] x = {-1, 0, 1, 0};
	static int[] y = {0, 1, 0, -1};
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+2][N+2];

		
		for(int i=1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		// 최대 최소
		int max = arr[1][1];
		int min = arr[1][1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
				}
				if(min > arr[i][j]) {
					min = arr[i][j];
				}
			}
		}
//		System.out.println(max);
//		System.out.println(min);
		List<Integer> list = new ArrayList<>();
		
		for(int k=0; k<max; k++) {
			bool = new boolean[N+2][N+2];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(arr[i][j] > k) {
						bool[i][j] = true;
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(bool[i][j] == true) {
						dfs(i,j, k);
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}
		System.out.println(Collections.max(list));
	}
	static void dfs(int i, int j, int k) {
		if(bool[i][j] == false) {
			return;
		}
		if(arr[i][j] > k) {
			bool[i][j] = false;
			for(int a=0; a<x.length; a++) {
				if(bool[i + x[a]][j + y[a]] == true) {
					dfs(i + x[a], j + y[a], k);
				}
			}
		}else {
			return;
		}
	}
}

