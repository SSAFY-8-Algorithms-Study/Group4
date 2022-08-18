package silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_16922 {
	static int N;
	
	static char[] resultList;
	static final char[] inputList = {'I', 'V', 'X', 'L'};
	
	static Set<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		resultList = new char[N];
		
		comb(0, 0);
		
		System.out.println(set.size());
	}
	
	static void comb(int count, int start) {
		if(count == N) {
			Integer sum = 0;
//			System.out.println(Arrays.toString(resultList));
			
			for(char value : resultList) {
				if(value == 'I') {
					sum += 1;
				}
				if(value == 'V') {
					sum += 5;
				}
				if(value == 'X') {
					sum += 10;
				}
				if(value == 'L') {
					sum += 50;
				}
			}
			
			set.add(sum);
			
			return;
		}
		
		for (int i = start; i < inputList.length; i++) {
			resultList[count] = inputList[i];
			comb(count+1, i);
		}
	}
}
