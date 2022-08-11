package silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int maxHeight = 0;
		int maxLength = 0;
		
		int[][] warehouse = new int[N][2];
		
		for (int i = 0; i < warehouse.length; i++) {
			// 거리
			warehouse[i][0] = sc.nextInt();
			
			//높이
			warehouse[i][1] = sc.nextInt();
			if(warehouse[i][1] > maxHeight) {
				maxHeight = warehouse[i][1];
				maxLength = warehouse[i][0];
			}
			
//			maxHeight = Math.max(maxHeight, warehouse[i][1]);
		}
		
		Arrays.sort(warehouse, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		        return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
		    }
		});
		
//		for(int[] li : warehouse) {
//			System.out.println(Arrays.toString(li));
//		}
//		
		
		int sumLeft = 0;
		int sumRight = 0;
		
		int startLen = warehouse[0][0];
		int endLen = warehouse[N-1][0];
		
//		System.out.println("startLen: " +startLen);
//		System.out.println("endLen: " +endLen);
		
		boolean[] checkValueList = new boolean[endLen+1];
		
		//flag 처리
		for(int[] list : warehouse) {
			checkValueList[list[0]] = true;
		}
		
		int currentHeight = warehouse[0][1];
		
		int tempHeight = 0;
		
//		System.out.println("maxLength: " + maxLength);
		
		for (int i = startLen; i < maxLength; i++) {
			//만약 해당 위치에 지붕이 있으면
			if(checkValueList[i]) {
				//이전 지붕보다 큰지 검사
				for(int[] list : warehouse) {
					if(list[0] == i) {
						tempHeight = list[1];
					}
				}
				
				if(tempHeight > currentHeight) {
					currentHeight = tempHeight;
				}
			}
			
//			System.out.println("index: " + i +" addValue: " + currentHeight);
			
			sumLeft += currentHeight;
		}
		
		currentHeight = warehouse[N-1][1];
		
		for (int i = endLen; i > maxLength; i--) {
			//만약 해당 위치에 지붕이 있으면
			if(checkValueList[i]) {
				//이전 지붕보다 큰지 검사
				for(int[] list : warehouse) {
					if(list[0] == i) {
						tempHeight = list[1];
					}
				}
				
				if(tempHeight > currentHeight) {
					currentHeight = tempHeight;
				}
			}
			
			
			sumRight += currentHeight;
		}
		
//		int result = sumRight + sumLeft;
		int result = sumRight + sumLeft + maxHeight;
		
		System.out.println(result);
	}
}
