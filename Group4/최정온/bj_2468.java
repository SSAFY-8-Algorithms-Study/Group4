package test;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2468 {
    static int N;
    static int[][] test_board;
    
    static boolean dfs(int x, int y) {
        //범위를 벗어날 경우
        if(x <0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        
        //물에 안잠긴지 체크
        if(test_board[x][y] == 0) {
            //체크 확인
            test_board[x][y] = 1;
            //up
            dfs(x-1, y);
            //right
            dfs(x, y+1);
            //down
            dfs(x+1, y);
            //left
            dfs(x, y-1);
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        int[][] board = new int[N][N];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        //여기까지 입력
        
        //디버깅
//        for (int i = 0; i < board.length; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
        
        int answer= 1;
        
        //height = 높이
        for (int height = 1; height <= 100; height++) {
            //임시 보드 생성
            test_board = new int[board.length][board.length];
            
            //테스트 보드 값 넣어주기
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    //해당 위치가 물에 잠기면
                    if(board[i][j] <= height) {
                        test_board[i][j] = 1;
                    } //물에 안잠기면 
                    else {
                        test_board[i][j] = 0;
                    }
                }
            }
            
            int result = 0;
            //영역 찾기
            for (int i = 0; i < test_board.length; i++) {
                for (int j = 0; j < test_board.length; j++) {
                    if(dfs(i, j)) {
                        result++;
                    }
                }
            }
            
            answer = Math.max(answer, result);
        }
        
        System.out.println(answer);
    }
}