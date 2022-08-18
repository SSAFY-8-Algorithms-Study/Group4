import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1051 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char[][] arr = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		int x = N > M ? M : N;
		List<Integer> list = new ArrayList<>();
		
		for(int i = x; i>=1; i--) {
			if(i == 1) {
				list.add(1);
				break;
			}
			for(int a=0; a<N-i+1; a++) {
				for(int b=0; b<M-i+1; b++) {
					if(arr[a][b] == arr[a][i-1+b] &&  arr[a][b] == arr[i-1+a][b] && arr[a][b] == arr[i-1+a][i-1+b]) {
						list.add(i*i);
						break;
					}
				}
			}
		}
		System.out.println(Collections.max(list));
	}
}
