import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;	// N개의 줄에 A배열의 값이 주어짐
	static int M;	// M개의 줄에 나무 정보
	static int K;	// K년
	static int[][] A;
	static int[][] waterArr;
	static ArrayList<Tree> treeList;
	static ArrayList<Tree> tempList;
	static int totalTree = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		A = new int[N+1][N+1];		//로봇이 추가하는 양분
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		waterArr = new int[N+1][N+1];		//초기 양분
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				waterArr[i][j] = 5;
			}
		}
		

		treeList = new ArrayList<>();

		
		//상도가 심은 나무의 정보 x, y, age
		for(int m=0; m<M; m++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			
			treeList.add(new Tree(x,y,age,false));
			totalTree++;
		}
		
		// 시뮬레이션
		for(int k=0; k<K; k++) {
			spring();
			summer();
			fall();
			winter();
			//print();
		}

		System.out.println(totalTree);
	}
	static void spring() {
		Collections.sort(treeList);
		for(int i=0; i<treeList.size(); i++) {
			Tree t = treeList.get(i);
				
			if(waterArr[t.i][t.j] >= t.age) {		//양분이 나이보다 같거나 많아야
				waterArr[t.i][t.j] -= t.age;
				t.age++;
			}else {		//양분이 모자라....	
				t.dead = true;
			}
		}
	}
	static void summer() {
		tempList = new ArrayList<>();
		//totalTree -= tempList.size();
		for(int i=0; i<treeList.size(); i++) {
			// 여기서 부터
			Tree t = treeList.get(i);
			if(t.dead) {
				waterArr[t.i][t.j] += t.age / 2;
				totalTree--;
			}else {
				tempList.add(t);	//안죽은거 담아놔..
			}

		}
		treeList = tempList;	//안죽은거 옮겨
	}
	static int di[] = {-1, -1, -1, 0, 0, +1, +1, +1};
	static int dj[] = {-1, 0, +1, -1, +1, -1, 0, +1};
	
	static void fall() {
		tempList = new ArrayList<>();
		for(Tree now : treeList) {
			tempList.add(now);
			if(now.age % 5 == 0) {	// 나이가 5의 배수이면~
				for(int d=0; d<8; d++) {	//인접한 칸
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					
					if(nexti <1 || nexti >= N+1 || nextj < 1 || nextj >= N+1) {
						continue;
					}
					tempList.add(new Tree(nexti, nextj, 1, false)); // 인접 칸에 새 나무 생성
					totalTree++;
				}
			}
		}
		treeList = tempList;
	}
	static void winter() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				waterArr[i][j] += A[i][j];
			}
		}
	}
	static void print() {
		System.out.println("---------------------------------------");
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				System.out.print(waterArr[i][j]+ " ");
			}
			System.out.println();
			
		}
	}
	static class Tree implements Comparable<Tree>{
		int i;
		int j;
		int age;
		boolean dead = false;

		public Tree(int i, int j, int age, boolean dead) {
			this.i = i;
			this.j = j;
			this.age = age;
			this.dead = dead;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}
}
