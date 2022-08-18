import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		char arr[][]=new char[8][8];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
	
		
		for(int i=0;i<8;i++) {
			String a=br.readLine();
			for(int z=0;z<8;z++) {
				
				arr[i][z]=a.charAt(z);
				
				
				
				
			}
			
			
		}
		//System.out.println(Arrays.toString(arr));
		
		//짝 홀 짝 홀..
		int count=0;
		
		for(int i=0;i<8;i++) {
			for(int z=0;z<8;z++) {
				
				if(arr[i][z]==('F')& i %2==0) {
					//System.out.println("@@");
					if(z%2==0) {
						
						count++;
						
					}
					
					
					
				}
				
				else if(arr[i][z]==('F')& i %2==1) {
					
					if(z%2==1) {
						
						count++;
						
					}
					
					
				}
				
				
				
			}
			
			
		}
		
		
		
		System.out.println(count);
		
		
		
		
	}
}