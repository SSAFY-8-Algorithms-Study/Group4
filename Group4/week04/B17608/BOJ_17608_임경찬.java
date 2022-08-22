
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		int max = 0;
		int max_idx = 0;
		int answer=0;

		for (int a = 0; a < n; a++) {

			int s = sc.nextInt();

			stack.add(s);



		}
		

		
		
		for(int i=n-1;i>=0;i--) {
			
			
			if (max != Math.max(stack.get(i), max)) {

				max = stack.get(i);
				max_idx = i;
				answer++;
				

			}
			
		}
		
		
		
		
		
		

		
		
		//System.out.println(stack.toString());
		System.out.println(answer);

		return;

	}

}
