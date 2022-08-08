import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2563 {
	// B2563 색종이
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		
		for(int i=0; i<C; i++) {
			String[] str = br.readLine().split(" ");
			
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			
			int x2 = x1+10;
			int y2 = y1+10;
			
			for(int a=x1; a<x2; a++) {
				for(int b=y1; b<y2; b++) {
					arr[a][b] += 1;
				}
			}
		}
		int count = 0;
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(arr[i][j] != 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
