package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1193_분수찾기 {
	static int[] di = {0, +1, +1, -1};
	static int[] dj = {+1, -1, 0, +1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int X = 1;
		int Y = 1;
		
		int i=0;
		int nowi=0, nowj=0;
		int nexti = 0, nextj= 0;
		
		for(int a=1; a<N; a++) {
			if(i==0 || i==2) {
				nowi += di[i];
				nowj += dj[i];
				
				X += di[i];
				Y += dj[i];
				
				i++;
			}else {
				nexti = nowi + di[i];
				nextj = nowj + dj[i];
				
				if(nexti < 0 || nextj < 0) {
					a-=1;
					i++;
				}else {
					nowi = nexti;
					nowj = nextj;
					X += di[i];
					Y += dj[i];
				}
			}
			if(i == 4) {
				i = 0;
			}
		}
		System.out.println(X + "/" + Y);
	}
}
