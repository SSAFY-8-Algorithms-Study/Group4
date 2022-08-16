
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int answer1 = 0;
	public static int answer2 = 0;

	public static boolean visit[][];

	public static void function(int arr[][], int n, int start_x, int start_y) {

		if (n == 1) {
		

			return;
		}

	//	System.out.println(Arrays.deepToString(visit));
	//	System.out.println("N="+n);

		int counter = 0;

		for (int i = start_y; i < start_y + n / 2; i++) {

			for (int j = start_x; j < n / 2 + start_x; j++) {

				if (arr[i][j] == 1 && visit[i][j] == false) {
					counter++;

				}

				else if (arr[i][j] == 0 && visit[i][j] == false) {

					counter--;

				}

			}
		} // 1

		if (counter == (n / 2) * (n / 2)) {

			//System.out.println(counter + " ans1++" + "n= " + n + " s_x=" + start_x + " s_y=?" + start_y);
			answer1++;

			for (int i = start_y; i < start_y + n / 2; i++) {

				for (int j = start_x; j < start_x + n / 2; j++) {

					visit[i][j] = true;
				}

			}

		}

		else if ((n / 2) * (n / 2) == Math.abs(counter)&& counter<0) {
			//System.out.println(counter + " ans2++" + "n= " + n + " s_x=" + start_x + " s_y=?" + start_y);
			answer2++;

			for (int i = start_y; i < start_y + n / 2; i++) {

				for (int j = start_x; j < start_x + n / 2; j++) {

					visit[i][j] = true;
				}

			}

		}

		counter = 0;
		
		
		

		for (int i = start_y; i < start_y + n / 2; i++) {

			for (int j = start_x + n / 2; j < n + start_x; j++) {

				if (arr[i][j] == 1 && visit[i][j] == false) {
					counter++;
				}
				else if (arr[i][j] == 0 && visit[i][j] == false) {

					counter--;

				}

			}

		} // 2

		if (counter == (n / 2) * (n / 2)) {
			//System.out.println(counter + " ans1++" + "n= " + n + " s_x=" + start_x + " s_y=!" + start_y);
			answer1++;
			for (int i = start_y; i < start_y + n / 2; i++) {

				for (int j = start_x + n / 2; j < n + start_x; j++) {

					visit[i][j] = true;

				}

			} // 2
		}

		else if ( counter<0 && (n / 2) * (n / 2) == Math.abs(counter)) {

			for (int i = start_y; i < start_y + n / 2; i++) {

				for (int j = start_x + n / 2; j < n + start_x; j++) {

					visit[i][j] = true;

				}

			} // 2
		//	System.out.println(counter + " ans2++" + "n= " + n + " s_x=" + start_x + " s_y=!" + start_y);
			answer2++;

		}

		counter = 0;

		for (int i = n / 2 + start_y; i < n + start_y; i++) {

			for (int j = n / 2 + start_x; j < n + start_x; j++) {

				if (arr[i][j] == 1 && visit[i][j] == false) {
					counter++;
				}
				else if (arr[i][j] == 0 && visit[i][j] == false) {

					counter--;

				}

			}

		} // 3
		if (counter == (n / 2) * (n / 2)) {
			//System.out.println(counter + " ans1++" + "n= " + n + " s_x=" + start_x + " s_y=@" + start_y);
			answer1++;
			for (int i = n / 2 + start_y; i < n + start_y; i++) {

				for (int j = n / 2 + start_x; j < n + start_x; j++) {

					visit[i][j] = true;

				}

			}

		}

		else if ((n / 2) * (n / 2) == Math.abs(counter)&& counter<0){
			//System.out.println(counter + " ans2++" + "n= " + n + " s_x=" + start_x + " s_y=@" + start_y);
			answer2++;
			for (int i = n / 2 + start_y; i < n + start_y; i++) {

				for (int j = n / 2 + start_x; j < n + start_x; j++) {

					visit[i][j] = true;

				}

			}

		}

		counter = 0;

		for (int i = n / 2 + start_y; i < n + start_y; i++) {

			for (int j = start_x; j < n / 2 + start_x; j++) {

				if (arr[i][j] == 1 && visit[i][j] == false) {
					counter++;
				}
				else if (arr[i][j] == 0 && visit[i][j] == false) {

					counter--;

				}
			}
		} // 4
		if (counter == (n / 2) * (n / 2)) {
			//System.out.println(counter + " ans1++" + "n= " + n + " s_x=" + start_x + " s_y=#" + start_y);

			answer1++;

			for (int i = n / 2 + start_y; i < n + start_y; i++) {

				for (int j = start_x; j < n / 2 + start_x; j++) {

					visit[i][j] = true;

				}
			} // 4
		} else if ((n / 2) * (n / 2) == Math.abs(counter)&& counter<0){
			//System.out.println(counter + " ans2++" + "n= " + n + " s_x=" + start_x + " s_y=#" + start_y);
			answer2++;

			for (int i = n / 2 + start_y; i < n + start_y; i++) {

				for (int j = start_x; j < n / 2 + start_x; j++) {

					visit[i][j] = true;

				}
			} // 4

		}

		counter = 0;

		function(arr, n / 2, start_x, start_y);
		function(arr, n / 2,start_x+ n/2, start_y);
		function(arr, n / 2, start_x+n/2, start_y+ n/2);
		function(arr, n / 2, start_x, start_y+ n/2);
		
		
		


	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();

		int n = Integer.parseInt(a);

		int arrin[][] = new int[n][n];

		int temp1 = 0;
		for (int i = 0; i < n; i++) {
			a = br.readLine();
			StringTokenizer st = new StringTokenizer(a);

			for (int z = 0; z < n; z++) {

				arrin[i][z] = Integer.parseInt(st.nextToken());
				if (arrin[i][z] == 1) {
					temp1++;
				}

			}
		}
		// input

		if (temp1 == n * n) {

			System.out.println("0");
			System.out.println("1");
			return;

		} else if (temp1 == 0) {
			System.out.println("1");
			System.out.println("0");
			return;
		}

		Main.visit = new boolean[n][n];

		Main.function(arrin, n, 0, 0);
	//	System.out.println("1 complete" + Main.answer1 + " " + Main.answer2);

	//	Main.function(arrin, n / 2, n / 2, 0);
	//	System.out.println("2 complete" + Main.answer1 + " " + Main.answer2);
	//	Main.function(arrin, n / 2, n / 2, n / 2);
	//	System.out.println("3 complete" + Main.answer1 + " " + Main.answer2);
		//Main.function(arrin, n / 2, 0, n / 2);
		
	//	System.out.println("4 complete" + Main.answer1 + " " + Main.answer2);
		
		System.out.println(Main.answer2);
		System.out.println(Main.answer1);
		
		

	}

}
