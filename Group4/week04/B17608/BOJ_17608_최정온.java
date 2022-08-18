package bronze;

import java.util.Scanner;
import java.util.Stack;

public class Main_17608 {
	static int N;
	static int[] numberList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		numberList = new int[N];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			numberList[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				stack.push(numberList[i]);
//				System.out.println("stack Push: " + numberList[i] );
			} else {
				if(numberList[i] >= stack.peek()) {
					while(true) {
						if(stack.isEmpty() || numberList[i] < stack.peek()) {
							break;
						}
						Integer value = stack.pop();
//						System.out.println("stack Pop: " +value );
					}
					stack.push(numberList[i]);
//					System.out.println("stack Push: " + numberList[i] );
				} else {
					stack.push(numberList[i]);
//					System.out.println("stack Push: " + numberList[i] );
				}
			}
		}
		
		System.out.println(stack.size());
	}
}
