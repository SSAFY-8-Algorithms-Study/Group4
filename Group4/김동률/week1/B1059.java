import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B1059 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] arr = new int[L+1];
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<L; i++) {
			arr[i] = Integer.parseInt(s[i]);
			list.add(arr[i]);
		}
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		if(list.contains(n)) {
			
		}else {
			arr[L] = n;
			
			Arrays.sort(arr);
			int a = 0;
			int b = 0;
			//제일 작은 수 이면
			if(arr[0] == n && arr[0] > 1) {
				//count += arr[1] - n -1;
				a = 1;
				b = arr[1]-1;
				
			}else if(arr[0] == n && n == 1){
				count = arr[1] - 2;
			}else {
				//
				for(int i=1; i<L; i++) {
					if(arr[i] == n) {
						a = arr[i-1]+1;
						b = arr[i+1]-1;
						break;
					}
				}
			}
			if(a == b) {
			
			}else {
				for(int i=a; i<n; i++) {
					count += b-n+1;
				}
				count+= b-n;
			}
		}	
		System.out.println(count);
	}
}

