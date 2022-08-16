import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// 주어지는 것은 시작좌표

		int input[][] = new int[102][102];

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		for (int i = 1; i <= n; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = y + 1; j <= y + 10; j++) {

				for (int k = x + 1; k <= x + 10; k++) {

					input[j][k] = 1;

				}
			}

		}
		// 색칠

		int count = 0;

		// System.out.println(Arrays.deepToString(input));

		for (int i = 1; i <= 100; i++) {

			for (int j = 1; j <= 100; j++) {

				if (input[i][j] == 1) {

					// System.out.println("@!@!@");
					

						

							count++;

						

					

				}

			}

		}

		System.out.println(count);

	}

}