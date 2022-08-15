package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Con[] arr = new Con[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Con(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);

		Con nowC = arr[0];
		int count = 1;
		for(int i=1; i<arr.length; i++) {
			boolean flag = true;
			
			Con nextC = arr[i];
			
			if(nextC.start >= nowC.end || nextC.end <= nowC.start) {
				// 가능한 경우
				nowC = nextC;
				count++;
			}
		}
		System.out.println(count);
	}
	static class Con implements Comparable<Con>{
		int start;
		int end;
		
		public Con(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Con o) {
			// TODO Auto-generated method stub
			//return (end-start) - (o.end-o.start);
			return end-o.end;
			//return (start-o.start);
		}
	}
}

