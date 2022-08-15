package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B2304_창고다각형 {
	static int[] value;
	static int[] index;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Bar> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		value = new int[N];
		index = new int[N];

		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			value[i] = Integer.parseInt(s[1]);
			index[i] = Integer.parseInt(s[0]);
			list.add(new Bar(index[i], value[i]));
		}
		//N이 1일 때 
		if(N == 1) {
			System.out.println(value[0] * 1);
			return;
		}
		
		Collections.sort(list);
		
//		for(Bar b : list) {
//			System.out.println(b.index + ", " + b.value);
//		}
		int max = Arrays.stream(value).max().getAsInt();
		int maxIdx1 = 0;
		int maxIdx2 = 0;
		//앞에서 부터 검사 -> 최대값 언제나오는지
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).value == max) {
				maxIdx1 = i;
				break;
			}
		}
		// 뒤에서 부터 검사 -> 최대값 언제나오는지
		for(int i=list.size()-1; i>=0; i--) {
			if(list.get(i).value == max) {
				maxIdx2 = i;
				break;
			}
		}

		Bar nowBar = list.get(0);
		Bar nextBar;
		
		int sum = 0;
		// 왼쪽 넓이 구하기
		for(int i=1; i<=maxIdx1; i++) {
			nextBar = list.get(i);
			// 현재 높이보다 다음 높이가 더 크면
			if(nowBar.value < nextBar.value) {
				sum += Math.abs(nowBar.index - nextBar.index) * nowBar.value;
				nowBar = nextBar;
				nextBar = list.get(i);
			}else {
				nextBar = list.get(i+1);
			}
		}
		// list.size = 7
		int size = list.size()-1;
		nowBar = list.get(size);
		// 오른쪽 넓이 구하기
		for(int i=size-1; i>=maxIdx2; i--) {
			nextBar = list.get(i);
			// 현재 높이보다 다음 높이가 더 크면
			if(nowBar.value < nextBar.value) {
				sum += Math.abs(nowBar.index - nextBar.index) * nowBar.value;
				nowBar = nextBar;
				nextBar = list.get(i-1);
			}else {
				nextBar = list.get(i-1);
			}
		}
		// 가운데 넓이 구하기
		if(maxIdx2 == maxIdx1) {
			sum += list.get(maxIdx1).value;
		}else {
			sum += (Math.abs(list.get(maxIdx2).index-list.get(maxIdx1).index)+1) * list.get(maxIdx1).value;
		}
		System.out.println(sum);
	}
}
class Bar implements Comparable<Bar>{
	int value;
	int index;
	
	public Bar(int index, int value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Bar o) {
		if(index > o.index) {
			return 1;
		}else if(index < o.index) {
			return -1;
		}else {
			return 0;
		}
	}
}
