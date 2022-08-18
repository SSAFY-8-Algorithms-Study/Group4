package silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//N보다 작거나 같은 모든 소수를 찾기
public class Main_2960 {
	static int N;
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		int count = 0;
		
		//index를 1부터 사용하기 위해
		int[] numberList = new int[N+1];
		
		ArrayList<Integer> removeList = new ArrayList<>();
		
		for (int i = 2; i <= N; i++) {
			numberList[i]= i;
		}
		//Input End
		
//		System.out.println(Arrays.toString(numberList));
		
		//p는 2부터 시작
		int P = 2;
		
		while(true) {
			if(count== K) {
				break;
			}
			
			for (int i = 1; i <= N; i++) {
				//삭제 인덱스 구하기
				int removeIndex = P * i;
				
				//범위 체크
				if(removeIndex >= N+1) {
					break;
				}
				
				//삭제는 0으로 처리
				if(numberList[removeIndex] == 0) {
					continue;
				}
				
				removeList.add(numberList[removeIndex]);
				numberList[removeIndex]= 0;
				count++;
//				System.out.println(Arrays.toString(numberList));
//				System.out.println("count: " + count);
				
				if(count== K) {
					break;
				}
			}
			
			for (int i = 0; i <= N; i++) {
				//아직 지워지지 않은 수 중 가장 작은 수를 찾는다.
				if(numberList[i] != 0) {
					P = i;
					break;
				}
			}
		}
		
		System.out.println(removeList.get(count-1));
	}
}
