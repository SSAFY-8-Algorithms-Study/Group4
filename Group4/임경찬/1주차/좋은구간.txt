import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		
		
		// 
		
		//정수 집합 S가 주어졌을때, 다음 조건을 만족하는 구간 [A, B]를 좋은 구간이라고 한다.

	//	A와 B는 양의 정수이고, A < B를 만족한다.
	//	A ≤ x ≤ B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다.
	//	집합 S와 n이 주어졌을 때, n을 포함하는 좋은 구간의 개수를 구해보자.
		
	//첫째 줄에 집합 S의 크기 L이 주어진다. 둘째 줄에는 집합에 포함된 정수가 주어진다. 셋째 줄에는 n이 주어진다.	
		
		//첫째 줄에 집합 S의 크기 L이 주어진다. 둘째 줄에는 집합에 포함된 정수가 주어진다. 셋째 줄에는 n이 주어진다.
		
		//1 ≤ L ≤ 50
		//집합 S에는 중복되는 정수가 없다.
	//	집합 S에 포함된 모든 정수는 1보다 크거나 같고, 1,000보다 작거나 같다.
	//	1 ≤ n ≤ (집합 S에서 가장 큰 정수)
		
		
		Scanner sc = new Scanner(System.in);
		
		int l=sc.nextInt();
		int arrin[]=new int[l];
		
		// 1~50  ->L
		int max=0;
		
		for(int i=0;i<l;i++) {
			
			arrin[i]=sc.nextInt();
			
			if(max<Math.max(max, arrin[i])) {
				
				max=arrin[i];
				
				
			}
		}
		
		int n=sc.nextInt();
		
		
		
		int cnt=0;
		int checker=0;
	
	
	for(int i=1;i<max;i++) {
		int A=i;
		// a지정 
		
		for(int k=0;k<max;k++) {
			// k=b 지정 
			
			if(A<k) {
				//조건 1 
				
				for(int x=A;x<=k;x++) {
					//A~K 사이에 S집합 정수가 있는지 확인.
					
					for(int s=0;s<arrin.length;s++) {
						
						if(x==arrin[s]) {
							checker++;
							break;
							
						}
						
					}
					
					
				}//x 가 모두 검사받는다 
				if(checker==0) {
					
					
						
						if(k-A>=k-n&k-n>=0) {
							//System.out.println("A="+A+"K="+k);
							cnt++;
							
						}
						
						
						
					
					
					
					// iz=n값포함여부확인 
					
					
					
				}//검사합격시 A~K는 좋은구간이 맞음 
				checker=0;
				
				
			}
			
			
			
		}
		
		
	}
	
	
		System.out.println(cnt);
	
	
	
	
}
	




}