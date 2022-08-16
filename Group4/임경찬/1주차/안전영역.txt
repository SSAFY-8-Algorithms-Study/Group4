import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int dx[] = { 1, -1, 0, 0 };
	public static int dy[] = { 0, 0, -1, 1 };
	public int n;
	public int rain;// 1~100

	public boolean visit[][];
	// right left up down check

	public Main(int input) {

		this.n = input;

		visit = new boolean[n + 2][n + 2];

	}

	int dfs(int arr[][], int cur_x, int cur_y) {

		int cur_check = 0;

		if (arr[cur_y][cur_x] > this.rain) {

			cur_check++;
			visit[cur_y][cur_x] = true;
			// System.out.println("c_y="+cur_y+" cur_x="+cur_x+" = "+visit[cur_y][cur_x]);

		} // current point check

		if (cur_check == 0) {

			return 0;
		}

		for (int z = 0; z < dx.length; z++) {

			if (visit[cur_y + dy[z]][cur_x + dx[z]] == false && arr[cur_y + dy[z]][cur_x + dx[z]] > this.rain
					&& cur_check == 1) {

				switch (z) {

				case 0:
					dfs(arr, cur_x + 1, cur_y);
					// R=1;

					break;
					
				case 1:
					dfs(arr, cur_x -1, cur_y);
					// R=1;

					break;
					

				case 2:
					// u=1;
					dfs(arr, cur_x, cur_y - 1);
					break;

				case 3:
					// D=1;
					dfs(arr, cur_x, cur_y + 1);
					break;

				}

			}

		} // delta searching--

		return 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int safe_count = 0;

		int a = Integer.parseInt(br.readLine());

		Main sz = new Main(a);

		int arrin[][] = new int[sz.n + 2][sz.n + 2];

		StringTokenizer st;

		int min = 100;
		int max = 0;

		for (int i = 1; i <= sz.n; i++) {
			String aa = br.readLine();
			st = new StringTokenizer(aa);
			for (int z = 1; z <= sz.n; z++) {

				arrin[i][z] = Integer.parseInt(st.nextToken());
				if (Math.max(max, arrin[i][z]) != max) {

					max = arrin[i][z];
				}
				if (Math.min(min, arrin[i][z]) != min) {

					min = arrin[i][z];
				}

			}

		} // input complete

		int max_out = 0;

		for (int rr = min; rr <= max; rr++) {
			sz = new Main(a);
			sz.rain = rr;

			for (int i = 1; i <= sz.n; i++) {

				for (int z = 1; z <= sz.n; z++) {

					// System.out.println(i + " " + z + "i@z@");
					if (sz.visit[i][z] == true) {
						continue;

					}
					// System.out.println(i + " " + z + "i!z!");
					safe_count += sz.dfs(arrin, z, i);

				}

			}
			// System.out.println(sz.rain+"<-rain"+rr+"@"+safe_count);

			if (Math.max(safe_count, max_out) > max_out) {

				max_out = safe_count;
			}

			safe_count = 0;

		}
		// System.out.println(Arrays.deepToString(sz.visit));
		if (max_out == 0) {

			System.out.println("1");
		} else {
			System.out.println(max_out);
		}

		return;
	}// main end

}
