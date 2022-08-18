package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class B1213_팰린드롬2 {
	static char[] alpha;
	static int[] count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		char[] arr = new char[s.length()];
		alpha = new char[26];
		count = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			arr[i] = s.charAt(i);
			//System.out.println(arr[i] - 'A');
			count[arr[i]-'A']++;
		}
		int flag = 0;
		char center = 'A';
		for(int i=0; i<count.length; i++) {
			//System.out.println(count[i]);
			if(count[i] % 2 != 0) {
				center += i;	//센터 값
				count[i]--;		//센터 값의 갯수 -1
				flag += 1;		//홀수 갯수
			}
		}
		if(flag > 1) {	//홀수가 2개 이상일 경우 끝
			//끝
			System.out.println("I'm Sorry Hansoo");
		}else {
			StringBuilder sb = new StringBuilder();
			//System.out.println(center);
			for(int i=0; i<26; i++) {
				if(count[i] != 0) {
					int len = count[i];
					for(int j=0; j<len/2; j++) {
						sb.append((char)('A'+ i));
					}
				}
			}
			
			if(s.length() % 2 == 0) {
				//짝수 일때 센터가 없음!
				System.out.println(sb.toString() + sb.reverse().toString());
			}else {
				//홀수 일때
				System.out.println(sb.toString() + center + sb.reverse().toString());
			}

		}
	}
}
