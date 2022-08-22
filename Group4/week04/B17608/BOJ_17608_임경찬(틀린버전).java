package D0822;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		int max = 0;
		int max_idx = 0;

		for (int a = 0; a < n; a++) {

			int s = sc.nextInt();

			stack.add(s);

			if (max != Math.max(s, max)) {

				max = s;
				max_idx = a;

			}

		}

		for (int s = 0; s < max_idx; s++) {

			stack.remove(0);
		}
		int temp = stack.size();

		int cur = 1;

		for (int s = 0; s < temp - 2; s++) {
			
			
		//	System.out.println(cur);
			while ((stack.get(cur) <= stack.get(cur + 1))) {
			//	System.out.println(stack.get(cur) + " " + stack.get(cur + 1));
				if (stack.get(cur) <= stack.get(cur + 1)) {

					stack.remove(cur);
					cur--;
					
					if (s == temp - 1  ) {
						break;

					}
				}


			}

			cur++;

			System.out.println(stack.toString());

		}

		System.out.println(stack.size());

		return;

	}

}
