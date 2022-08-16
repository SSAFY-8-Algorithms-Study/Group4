
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) throws Exception {
		
		int n,m;
		
		Scanner sc= new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		
		
		// n과  m 중 작은수로 사각형 꼭짓점 조사.
		
		int arr[][]=new int[n][m];
		
		
		
		
		
		for(int i=0;i<n;i++) {
			
			String a= sc.next();
			char arr1[]=a.toCharArray();
			
			for(int k=0;k<m;k++) {
				
				
				arr[i][k]= Character.getNumericValue(arr1[k]);
						
				
				
			}
			
			
			
		}
		//System.out.println(Arrays.deepToString(arr));
		
		int key= Math.min(n, m);//최대 지정크기 
		
		int res=1;

		
		
		
		for(int i=1;i<=key;i++) {
			
			
			for(int k=0;k<n;k++) {
				
				
				for(int z=0;z<m;z++) {
					
					if( i+k<n& i+z<m){
						
					
					if(arr[k][z]==arr[k][z+i] & arr[k][z]==arr[k+i][z]& arr[k][z]==arr[k+i][z+i]) {
						
						if(res<i+1) {
							res=i+1;
							
						}
						
					}
					
					}
					
					
					
					
					
					
				}
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		System.out.println(res*res);
		
		
		
		
		
		
		
	}
}