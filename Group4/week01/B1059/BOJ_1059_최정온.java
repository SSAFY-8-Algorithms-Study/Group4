package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1059 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());

		int[] list = new int[L];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < L; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int count = 0;

		int minNearLowerValue = Integer.MIN_VALUE;
		int maxNearUpperValue = Integer.MAX_VALUE;

		boolean equ = false;
		
		Arrays.sort(list);

		for (int i = 0; i < list.length; i++) {
			if (list[i] == n) {
				equ = true;
				break;
			}

			if (list[i] < n) {
				minNearLowerValue = Math.max(minNearLowerValue, list[i]);
			}

			if (list[i] > n) {
				maxNearUpperValue = Math.min(maxNearUpperValue, list[i]);
			}
		}
		

		if (!equ) {
			for (int i = minNearLowerValue+1; i <= n; i++) {
				for (int j = n; j < maxNearUpperValue; j++) {
//					System.out.print("i: " + i + " ");
//					System.out.println("j: " + j);
					if(i== j) {
						continue;
					}
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
