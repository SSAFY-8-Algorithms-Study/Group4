import java.util.Scanner;

public class Main {

	public static boolean prin(int a) {
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {

				return false;

			}

		}

		return true;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		// 2부터 N까지 모든 정수를 적는다.
		// 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
		// P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
		// 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
		// N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.

		int arr[] = new int[n + 1];

		for (int i = 0; i <= n; i++) {

			arr[i] = i;

		}

		int cnt = 0;

		for (int i = 2; i <= 1000; i++) {

			if (!Main.prin(i)) {
				continue;

			}

			for (int j = 1; j * i <= n; j++) {

				if (arr[i * j] == 0) {
					continue;
				}
				arr[i * j] = 0;
				cnt++;
				// System.out.println(i*j+"=0 "+cnt);
				if (cnt == k) {
					System.out.println(i * j);
					return;

				}

			}

		}

	}

}
