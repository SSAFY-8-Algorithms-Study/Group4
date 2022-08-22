
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	
	static int N,answer;
	
	
	public static int[] lister = {1,5,10,50};
	
	public static int[] numbers;
	public static HashSet<Integer> set= new HashSet<>();

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		
		N=sc.nextInt();
		
		numbers=new int [N];
		answer=0;
		
		comb(0,0);
		
		
		System.out.println(answer);

	}
	
	
	
	
	public static void comb(int cnt,int start) {
		
		if(cnt==N) {
			int sum=0;
			
			for(int i=0;i<numbers.length;i++) {
				
				if(numbers[i]!=0) {
					sum += numbers[i];
					
				}
				
			}
		
			if(set.add(sum)==true) {
				
				answer++;
				
				
			}
			
			return;
		}
		
		
		
		for(int i=start;i<lister.length;i++) {
			
			
			numbers[cnt]=lister[i];
			comb(cnt+1,i);
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
