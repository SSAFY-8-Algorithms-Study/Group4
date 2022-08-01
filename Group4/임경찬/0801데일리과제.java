package D801;

import java.util.Arrays;
import java.util.Scanner;

public class switchdailyhw {


	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		int snum=sc.nextInt();//스위치 개수 
		
		
		
		int arr_sw[]=new int[snum+1];//스위치 데이터 .
		
		
		
		
		for(int i=1;i<=snum;i++) {
			
			arr_sw[i]=sc.nextInt();
		}//스위치 입력 
		

		int stu_num=sc.nextInt(); //100이하의 양의 정수 
		//남자는 1 여자는 2로 표현된다.
		
		for(int i=0;i<stu_num;i++) {
			
			
			int code=sc.nextInt();
			
			
			
			
			if(code==1) {
				
				int gaven= sc.nextInt();
				
				for(int k=1;k<arr_sw.length;k++) {
					
					
					if(k%gaven==0) {
						
						
						if(arr_sw[k]==1) {
							
							arr_sw[k]=0;
							
						}
						else if(arr_sw[k]==0) {
							
							arr_sw[k]=1;
						}
						
						
					}
				}
				
			}//남자 
			
			else if(code ==2) {
				
				int gaven= sc.nextInt();
				
				
				if(arr_sw[gaven]==1) {
					
					arr_sw[gaven]=0;
					
				}
				else if(arr_sw[gaven]==0) {
					
					arr_sw[gaven]=1;
				}
				
				
				for(int k=1;k<=(arr_sw.length)/2;k++) {
					
					
					if ((gaven-k)>=1 & gaven+k<=(arr_sw.length-1)){
						
						if(arr_sw[gaven-k]==arr_sw[gaven+k]) {
							
							if(arr_sw[gaven-k]==1) {
								
								arr_sw[gaven-k]=0;
								arr_sw[gaven+k]=0;
								
							}
							else if(arr_sw[gaven-k]==0) {
								
								arr_sw[gaven-k]=1;
								arr_sw[gaven+k]=1;
							}
							
						}
						else {
							break;
						}
						
						
						
						
					}

				}
			}//여자 
		}
		

		
		for(int i=1;i<=snum;i++) {
			
			System.out.print(arr_sw[i]+" ");

			
			
			if(i%20==0) {
				
				System.out.println();
				
			}
			
		}
		
		
		// 스위치 상태 출력 - 정답 
		
		
		

	}

}
