
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		
		int  n= sc.nextInt();
		
		
		
		int count=0;
		int left=0;
		int right=0;
		
		if(n<=3) {
			switch(n) {
			
			case 1:
				System.out.println("1/1");
				break;
			case 2:
				System.out.println("1/2");
				break;
			case 3:
				System.out.println("2/1");
				break;
			
			
			}
			
		}
		else {
			count=3;
			int sum=0;
			int num=0;
			int oddcheck=0;//1 짝 0 홀
			
			while(true) {
				num++;
			sum+=num;
			if(sum>=n) {
				break;
			}	
			}
			//System.out.println(sum+"sum @"+num);
			
			// num 의 짝홀 여부 확인 후 시작점 결정 .
			if(num%2==0) {
				
				right=num;
				left=1;
				oddcheck=1;
				
			}
			else {
				right=1;
				left=num;
				
			}
			
			int ak= sum-num+1;//이전 라인 총합에서 
			//System.out.println(ak);
			while(n!=ak) {
				
				if(oddcheck==1) {
					right--;
					left++;
				}
				else {
					right++;
					left--;
					
				}
				
				ak++;
				
			}
			

			
			System.out.println(left+"/"+right);
			
			
		}
		
		
		
		
		
		
		
		
		
		

	}

}
