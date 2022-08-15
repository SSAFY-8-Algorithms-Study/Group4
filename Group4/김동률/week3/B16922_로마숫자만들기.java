package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B16922_로마숫자만들기 {
	static int[] arr = {1, 5, 10, 50};
	static int[] output;
	static int input;
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = Integer.parseInt(br.readLine());
		
		//중복 조합? 고른 것.
		output = new int[input];
		func(0, 0);
		System.out.println(set.size());
	}
	static void func(int cnt, int index) {
		if(cnt == input) {
			//System.out.println(Arrays.toString(output));
			int sum = 0;
			for(int i=0; i<output.length; i++) {
				sum+= output[i];
			}
			set.add(sum);
			return;
		}
		
		for(int i=index; i<4; i++) {
			output[cnt] = arr[i];
			func(cnt+1, i);
		}
	}
}
