import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class B2630 {
	static int[][] arr;
	static int bc;
	static int wc;
	//B2630 색종이 만들기
	public static void main(String[] args) throws Exception{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("B2630.txt"));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		bc = 0;
		wc = 0;
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<str.length; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int c = check(0, 0, N);
		if(c == 1) {
			bc++;
		}else if(c == 0) {
			wc++;
		}else {
			//System.out.println("시작");
			func(0,0,N/2);
		}

		System.out.println(wc);
		System.out.println(bc);

	}
	static void func(int a, int b, int index) {		// 8 / 2 = 4
		//System.out.println(a + "," + b);
		if(index == 0) {
			if(arr[a][b] == 1) {
				bc++;
			}else if(arr[a][b] == 0){
				wc++;
			}
			return;
		}
		
		// (0,0)
		int c1 = check(a + 0, b + 0, index);
		if(c1 == 1) {
			bc++;
		}else if(c1 == 0) {
			wc++;
		}else {
			func(a+0,b+0, index / 2);
		}
		
		// (0,4)
		int c2 = check(a + 0, b + index, index);
		if(c2 == 1) {
			bc++;
		}else if(c2 == 0) {
			wc++;
		}else {
			func(a+0,b + index, index / 2);
		}

		// (4,0)
		int c3 = check(a + index, b + 0, index);
		if(c3 == 1) {
			bc++;
		}else if(c3 == 0) {
			wc++;
		}else {
			func(a + index,b+0, index / 2);
		}

		// (4,4)
		int c4 = check(a + index, b + index, index);
		if(c4 == 1) {
			bc++;
		}else if(c4 == 0) {
			wc++;
		}else {
			func(a + index,b + index, index / 2);
		}
		//System.out.println("wc : " + wc + " bc : " + bc);
	}
	static int check(int a, int b, int n) {
		int total = n * n;
		int wc2 = 0;
		int bc2 = 0;
		//print(a,b,n);
		

		for(int i=a; i<a+n; i++) {
			for(int j=b; j<b+n; j++) {
				if(arr[i][j] == 1) {
					bc2++;
				}else if(arr[i][j] == 0) {
					wc2++;
				}
			}
		}

		//System.out.println();
		
		if(wc2 == total) {
			return 0;
		}
		if(bc2 == total) {
			return 1;
		}
		return -1;
	}
	
	static void print(int a, int b, int n) {
		for(int i=a; i<a+n; i++) {
			for(int j=b; j<b+n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		//System.out.println("wc : " + wc + " bc : " + bc);
	}
}
