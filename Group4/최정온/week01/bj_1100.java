package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1100 {
	public static void main(String[] args) throws IOException {
		char[][] board = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input_board = new String[8];
		
		int count = 0;
		
		for (int i = 0; i < input_board.length; i++) {
			input_board[i] = br.readLine();
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				//블랙판이 아니고 위에 말이 있다면 보드 업데이트 
				if(board[i][j] != 'B' && input_board[i].charAt(j) == 'F') {
					board[i][j] = input_board[i].charAt(j);
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(board[i][j] == 'F') {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
