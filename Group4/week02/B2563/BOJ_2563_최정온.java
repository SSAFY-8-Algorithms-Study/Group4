package bronze;

import java.util.Scanner;

public class Main_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[100][100];
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					map[i+x][j+y] = 1;
				}
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
