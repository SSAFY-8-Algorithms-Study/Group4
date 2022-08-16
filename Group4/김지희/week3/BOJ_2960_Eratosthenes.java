package week3;

import java.util.Scanner;

public class BOJ_2960_Eratosthenes {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] ch = new int[N+1];
		int cnt=0;
		int answer = 0;
		
		for(int i=2; i<=N;i++) {
			if(ch[i]!=0) {
				
				for(int j=i; j<=N; j+=i) {
					cnt++;
					ch[j] = 1;
					if(cnt==K) {
						answer = j;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
