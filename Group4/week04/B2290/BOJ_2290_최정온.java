package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2290 {
	static char[][] board;
	static int height;
	static int width;
	static int s;
	static int totalWidth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.nextInt();
		int n = sc.nextInt();

		String numberString = Integer.toString(n);

		height = 2 * s + 3;
		width = s + 2;

		// 가로 길 * 숫자 갯수 + 공백 갯수
		totalWidth = width * numberString.length() + numberString.length();

		board = new char[height][totalWidth];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < totalWidth; j++) {
				board[i][j] = ' ';
			}
		}
		
		int index = 0;
		
		for (int j = 0; j < totalWidth; j+= width+1) {
			char value = numberString.charAt(index);
			printNumber(0, j, value);
			index++;
		}
		printBoard();
	}

	static void printBoard() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < totalWidth; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		

//		for (char[] list : board) {
//			System.out.println(Arrays.toString(list));
//		}
	}

	static void printNumber(int startX, int startY, char value) {
		switch (value) {
		case '0':
			printTop(startX, startY);
			printTopLeft(startX, startY);
			printTopRight(startX, startY);
			printBottomLeft(startX, startY);
			printBottomRight(startX, startY);
			printBottom(startX, startY);
			break;
		case '1':
			printTopRight(startX, startY);
			printBottomRight(startX, startY);
			break;
		case '2':
			printTop(startX, startY);
			printTopRight(startX, startY);
			printMiddle(startX, startY);
			printBottomLeft(startX, startY);
			printBottom(startX, startY);
			break;
		case '3':
			printTop(startX, startY);
			printTopRight(startX, startY);
			printMiddle(startX, startY);
			printBottomRight(startX, startY);
			printBottom(startX, startY);
			break;
		case '4':
			printTopLeft(startX, startY);
			printTopRight(startX, startY);
			printMiddle(startX, startY);
			printBottomRight(startX, startY);
			break;
		case '5':
			printTop(startX, startY);
			printTopLeft(startX, startY);
			printMiddle(startX, startY);
			printBottomRight(startX, startY);
			printBottom(startX, startY);
			break;
		case '6':
			printTop(startX, startY);
			printTopLeft(startX, startY);
			printMiddle(startX, startY);
			printBottomLeft(startX, startY);
			printBottomRight(startX, startY);
			printBottom(startX, startY);
			break;
		case '7':
			printTop(startX, startY);
			printTopRight(startX, startY);
			printBottomRight(startX, startY);
			break;
		case '8':
			printTop(startX, startY);
			printTopLeft(startX, startY);
			printTopRight(startX, startY);
			printMiddle(startX, startY);
			printBottomLeft(startX, startY);
			printBottomRight(startX, startY);
			printBottom(startX, startY);
			break;
		case '9':
			printTop(startX, startY);
			printTopLeft(startX, startY);
			printTopRight(startX, startY);
			printMiddle(startX, startY);
			printBottomRight(startX, startY);
			printBottom(startX, startY);
			break;
		}

	}
	
	static void printTop(int startX, int startY) {
		int topStartX = startX;
		int topStartY = startY + 1;

		for (int i = 0; i < s; i++) {
			board[topStartX][topStartY + i] = '-';
		}
	}
	
	static void printMiddle(int startX, int startY) {
		int middleStartX = startX + s + 1;
		int middleStartY = startY + 1;

		for (int i = 0; i < s; i++) {
			board[middleStartX][middleStartY + i] = '-';
		}
	}
	
	static void printBottom(int startX, int startY) {
		int bottomStartX = startX + (2 * s) + 2;
		int bottomStartY = startY + 1;

		for (int i = 0; i < s; i++) {
			board[bottomStartX][bottomStartY + i] = '-';
		}
	}
	static void printTopLeft(int startX, int startY) {
		int topLeftStartX = startX + 1;
		int topLeftStartY = startY;

		for (int i = 0; i < s; i++) {
			board[topLeftStartX + i][topLeftStartY] = '|';
		}
	}
	static void printTopRight(int startX, int startY) {
		int topRightStartX = startX + 1;
		int topRightStartY = startY + s + 1;

		for (int i = 0; i < s; i++) {
			board[topRightStartX + i][topRightStartY] = '|';
		}
	}
	static void printBottomLeft(int startX, int startY) {
		int bottomLeftStartX = startX + s + 2;
		int bottomLeftStartY = startY;

		for (int i = 0; i < s; i++) {
			board[bottomLeftStartX + i][bottomLeftStartY] = '|';
		}
	}
	static void printBottomRight(int startX, int startY) {
		int bottomRightStartX = startX + s + 2;
		int bottomRightStartY = startY + s + 1;

		for (int i = 0; i < s; i++) {
			board[bottomRightStartX + i][bottomRightStartY] = '|';
		}
	}
}
