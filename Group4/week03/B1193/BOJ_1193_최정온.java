package bronze;

import java.util.Scanner;

public class Main_1193 {
	static final int[] dx = { 0, +1, +1, -1 }; // 오른쪽, 왼쪽 아래, 아래, 오른쪽 위
	static final int[] dy = { +1, -1, 0, +1 }; // 0, 1, 2, 3

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		int count = 1;
		// 오른쪽 부터 시작
		int direct = 0;

		int x = 1;
		int y = 1;

		while (count < X) {
//			System.out.println("count: " + count + ", x: " + x + " y: " + y);

			//오른쪽
			if (direct == 0) {
				y++;
			}
			//왼쪽 아래
			else if (direct == 1) {
				x++;
				y--;
			} 
			//아래 
			else if (direct == 2) {
				x++;
			}
			//오른쪽 위
			else if (direct == 3) {
				x--;
				y++;
			}
			
			//전환 조건
			//x가 1이고 y가 짝수이면 왼쪽 아래로 내려감
			if (x == 1 &&  y % 2 == 0) {
				direct = 1;
			}
			
			// y가 1이고 x가 짝수이면 아래로 내려감
			if (y == 1 && x % 2 == 0) {
				direct = 2;
			}
			
			//x가 1이고 y가 홀수이면 오른쪽으로 감
			if(x == 1 &&  y % 2 != 0) {
				direct = 0;
			}
			
			// y가 1이고 x가 홀수이면 오른쪽 위로 올라감
			if (y == 1 && x % 2 != 0) {
				direct = 3;
			}
			
			count++;
		}
		
		System.out.println(x + "/" + y);

	}
}
