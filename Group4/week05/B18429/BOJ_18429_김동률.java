import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] arr;
	static int[] output;
	static boolean[] selected;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N];
		output = new int[N];
		selected= new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		perm(0);
		System.out.println(count);
	}
	static void perm(int cnt) {
		if(cnt == N) {
			func(output);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(selected[i]) {
				continue;
			}
			selected[i] = true;
			output[cnt] = arr[i];
			perm(cnt+1);
			selected[i] = false;
		}
	}
	static void func(int[] output) {
		int weight = 500;
		for(int i=0; i<N; i++) {
			weight -= K;
			weight += output[i];
			if(weight < 500) {
				return;
			}
		}
		count++;
	}
}
