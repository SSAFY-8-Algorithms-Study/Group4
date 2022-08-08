import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1100 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		for(int i=1; i<=8; i++) {
			String input = br.readLine();
			if(i % 2 != 0) {
				//홀수칸
				for(int j=0; j<8; j++) {
					if(j % 2 == 0 && input.charAt(j) == 'F') {
						count++;
					}
				}
			}else {
				//짝수칸
				for(int j=0; j<8; j++) {
					if(j % 2 != 0 && input.charAt(j) == 'F') {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}

