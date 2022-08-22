package D0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class fellindrom {

	public static String not = "I'm Sorry Hansoo";

	public static void main(String[] args) throws IOException {

		int flag = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char arr_1[] = new char[51];// 앞뒤

		char arr_2[] = new char[51]; // 중간.

		String input = br.readLine();

		int arr1[] = new int[26];

		for (int i = 0; i < input.length(); i++) {
			char a = input.charAt(i);
			arr1[(int) a - 65]++;
		}

		for (int i = 0; i < 26; i++) {
			if (arr1[i] > 1) {

				flag = 1;
				break;
			}

		}

		if (input.length() == 1) {

			System.out.println(input);
			return;
		}

		if (flag == 0) {
			System.out.println(not);
			return;
		}

		flag = 0;

		int temp1 = 0;
		int temp2 = 0;

		for (int i = 0; i < 26; i++) {

			if (arr1[i] > 0) {
				// System.out.println("i="+i);

				if (arr1[i] == 1) {// 하나짜리이면 중간에 추가 .

					arr_2[temp2] = (char) (i + 65);

					temp2++;
				}

				else if (arr1[i] % 2 == 0) {

					int a = arr1[i] / 2;

					for (int is = i; is < a + i; is++) {

						arr_1[temp1] = (char) (i + 65);

						// System.out.println(arr_1[temp1]+"@@");
						temp1++;
					}

				} // 짝수개 존재.

				else if (arr1[i] % 2 == 1) {
					int a = arr1[i] / 2;

					for (int is = i; is < a + i; is++) {

						arr_1[temp1] = (char) (i + 65);
						temp1++;
					}

					arr_2[temp2] = arr_1[temp1 - 1];
					temp2++;

				} // 홀수개존재 .

			}

		}

		Arrays.sort(arr_1);
		Arrays.sort(arr_2);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr_1.length; i++) {

			if (arr_1[i] >= 65) {
				sb.append(arr_1[i]);
			}
			// System.out.print(arr_1[i]);

		}

		for (int i = 0; i < arr_2.length; i++) {
			if (arr_2[i] == ' ') {
				continue;
			}

			if (arr_2[i] >= 65) {
				flag++;
				sb.append(arr_2[i]);
			}

		}

		for (int i = arr_1.length - 1; i >= 0; i--) {
			if (arr_1[i] == ' ') {
				continue;
			}

			if (arr_1[i] >= 65) {
				sb.append(arr_1[i]);
			}
			// System.out.print(arr_1[i]);

		}

		if (flag >= 2) {

			System.out.println(not);
			return;
		}

		System.out.println(sb);
		return;

	}

}
