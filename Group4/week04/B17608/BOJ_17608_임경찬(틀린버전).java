
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		for (int a = 0; a < n; a++) {

			int s = sc.nextInt();
			stack.add(s);

		}
        
		int max_stack = stack.get(0);
		int max_idx = 0;
		int cur = 0;
        
		for (int a = 1; a < n - 1; a++) {
			cur++;

			if (stack.get(cur) >= max_stack) {// max보다 큰 경우 교체

				max_stack = stack.get(cur);
				max_idx= cur;

				for (int as = max_idx; as < cur; as++) {
					stack.remove(as);
					cur--;

				}

			} else if (stack.get(cur) < max_stack) {// max보다 작은 경우

				while (stack.get(cur) <= stack.get(cur + 1)) {
					stack.remove(cur);
					cur--;
					if(cur==max_idx) {
						break;
					}
				}

			}

		}

		System.out.println(stack.size());
		return;

	}

}
