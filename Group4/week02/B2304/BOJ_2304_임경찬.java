
import java.util.ArrayList;

import java.util.Arrays;

import java.util.Collections;

import java.util.Comparator;

import java.util.LinkedList;

import java.util.List;

import java.util.Scanner;
import java.util.Stack;

class stacker implements Comparable<stacker> {

	int x;

	int y;

	public stacker() {

	}

	public stacker(int x, int y) {

		this.x = x;

		this.y = y;

	}

	@Override

	public int compareTo(stacker o) {

		if (this.x > o.x) {

			return 1;

		}

		else if (this.x < o.x) {

			return -1;

		}

		else {

			return 0;

		}

	}

}

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		int arr_x[] = new int[TC];

		int arr_y[] = new int[TC];

		for (int i = 0; i < TC; i++) {

			arr_x[i] = sc.nextInt();

			arr_y[i] = sc.nextInt();

		}

		Stack<stacker> stack = new Stack<>();

		for (int z = 0; z < arr_y.length; z++) {

			stack.add(new stacker(arr_x[z], arr_y[z]));

		}

		Collections.sort(stack);


	//	System.out.println("@@@@@@@@@@@");
		
		int temp=1;
		
		
		
		
		
		if(TC==1) {
			
			System.out.println(stack.get(0).y);
			
			
			return ;
		}
		
		
		
		
		
		
		
		
		while(temp+1!=stack.size()){
//System.out.println(temp+"tetemp"+stack.size());
			if (stack.get(temp).y < stack.get(temp + 1).y && stack.get(temp).y <= stack.get(temp - 1).y) {
				//System.out.println(temp+"RM");
				stack.remove(temp);
				temp=1;
				continue;

			}
			temp++;

		}
		
		int max_stack=stack.get(0).y;
		
		
		for (int ss = 0; ss < stack.size(); ss++) {

			
			
			max_stack = Math.max(max_stack, stack.get(ss).y);
		//	System.out.println(stack.get(ss).x+"@#@@");

			//System.out.println(stack.get(ss).y+"@#@@");

		}
		
		
		
		
		
		
		int res=0;
		
		temp=0;
		
		while(temp!=stack.size()-1) {
			

			
			res+= (stack.get(temp+1).x-stack.get(temp).x )*stack.get(temp).y;
			
			//System.out.println(res+" temp="+temp);
			
			
			temp++;
			
			
			if(stack.get(temp).y==max_stack ) {
				//System.out.println("chekc");
				res+=max_stack;
				
				break;
			}
			
			
			
			
		}
		
		while(temp!=stack.size()-1) {
			
			
			res+= Math.abs(stack.get(temp).x-stack.get(temp+1).x )*stack.get(temp+1).y;
			
		//	System.out.println(res+" temp@="+temp);
			
			
			temp++;
			
		}
		
		
		
		System.out.println(res);
		
		
		return ;

	}

}