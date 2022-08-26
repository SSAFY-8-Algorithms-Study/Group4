package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_18429 {
	static int N;
	static int K;
	
	static int[] inputs;
	static int[] numbers;
	static boolean[] isSelected;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		K = sc.nextInt();
		
		inputs= new int[N];
		isSelected = new boolean[N];
		//N개만큼 뽑는다.
		numbers = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		//end Input
		
//		System.out.println(Arrays.toString(inputs));
		
		perm(0);
		System.out.println(answer);
	}
	
	static void perm(int count) {
		if(count == N) {
			int weight = 500;
			boolean check = true;
			
			for(int value : numbers) {
				//하루에 4킬로씩 빠짐
				weight -= K;
				weight += value;
				
//				System.out.println(weight);
				
				if(weight < 500) {
					check = false;
				}
			}
//			System.out.println("--------------------");
			
			if(check) {
				answer++;
			}
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {
				continue;
			}
			//사용
			numbers[count] = inputs[i];
			isSelected[i] = true;
			perm(count+1);
			isSelected[i] = false;
		}
		
		
	}
	
	
}
