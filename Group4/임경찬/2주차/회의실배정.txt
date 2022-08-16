
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		int count=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aa= br.readLine();
		
		
		int n=Integer.parseInt(aa);
		
		
		
		int arr[][]= new int[n][2];
	

		for(int s=0;s<n;s++) {
			aa=br.readLine();
			StringTokenizer st = new StringTokenizer(aa);
					
			arr[s][0]=Integer.parseInt(st.nextToken());
			arr[s][1]=Integer.parseInt(st.nextToken());
			
		}// input end 
		
		
		 // 두 수의 차이를 먼저 비교한다.
		// 그 안에서 같은 수치가 있다면  먼저 앞에숫자까 cur와 가장 가까운 것을 고른다.
		//고르면 뒤의 숫자로 cur를 변경해준다. 
		// 점수 산출에는 끝자리+ 두 수의 차이를 종합한 점수를 추산한다. 가장 낮은 점수+ 가장 빠른 번호를 추려 선택
		
		
		Arrays.sort(arr,new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
			
			
		});
		Arrays.sort(arr,new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
			
			
		});
		
		
		int end=0;
		
		
		for(int i=0;i<n;i++) {
			if(arr[i][0]>=end) {
				end=arr[i][1];
				count++;
			}
			
			
		}

		
		
		
		
	
		
		
		System.out.println(count);
		

	}

}
