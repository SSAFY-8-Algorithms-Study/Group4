package D0825;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class tree implements Comparable<tree> {

	int age;// 나이
	int state;// 생사 1 live 0 dead
	int x;
	int y;

	public tree(int age, int state, int x, int y) {

		this.age = age;
		this.state = state;
		this.x = x;
		this.y = y;

	}

	@Override
	public int compareTo(tree o) {// 작은 나무부터 양분을 주기위해 정렬 기준 정함.

		return Integer.compare(this.age, o.age);
	}

}

class Ground {

	int nutrition;// 양분
	int x;// 좌표 정보들
	int y;

	Queue<tree> tree_list = new LinkedList<>();// 이 땅에 심은 나무들 정보.

	public Ground(int nut, int x, int y) {

		this.nutrition = nut;
		this.x = x;
		this.y = y;
	}

	public void add_tree(int age, int state, int x, int y) {

		this.tree_list.add(new tree(age, state, x, y));

	}

	public void eat_nut() {

		ArrayList<tree> save = new ArrayList<>();
		int sz = tree_list.size();

		for (int s = 0; s < sz; s++) {

			tree cur = tree_list.poll();
			// System.out.println(cur.age+"^^"+tree_list.size());
			int temp_age = cur.age;

			if (this.nutrition > 0) {// 양분 존재시

				if (this.nutrition - temp_age < 0) {// 양분부족

					cur.state = 0;

				}

				else if (this.nutrition - temp_age >= 0) {// 양분 흡수

					this.nutrition = this.nutrition - temp_age;

					cur.age = cur.age + 1;

				}
			} else {// 양분 미존재

				cur.state = 0;

			}

			save.add(cur);
		}

		for (tree a : save) {

			this.tree_list.add(a);
		}

	}
	// 양분흡수 관련 메소드 끝

	public void summer_check() {

		ArrayList<tree> save = new ArrayList<>();

		int sz = tree_list.size();
		for (int s = 0; s < sz; s++) {

			tree cur = this.tree_list.poll();

			// System.out.println(cur.age+"@#");

			if (cur.state == 0) {

				int temp_age = cur.age;

				temp_age = temp_age / 2;

				this.nutrition += temp_age;

			}

			else if (cur.state == 1) {
				save.add(cur);
			}

		}
		for (tree as : save) {
			this.tree_list.add(as);
		}

	}

	public void winter_method(int nut_add) {

		this.nutrition += nut_add;
	}

}

public class Main{
	// {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static Ground map[][];
	static int N, M, K;

	static int winter_addmap[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		StringTokenizer st = new StringTokenizer(a);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new Ground[N][N];
		winter_addmap = new int[N][N];

		for (int i = 0; i < N; i++) {// map단위로 들어옴?

			a = br.readLine();
			st = new StringTokenizer(a);
			for (int j = 0; j < N; j++) {

				winter_addmap[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new Ground(5, j, i);
				

			}

		}

		for (int s = 0; s < M; s++) {// 나무 초기설정

			a = br.readLine();
			st = new StringTokenizer(a);

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			map[x][y].add_tree(z, 1, y, x);
			
			Collections.sort((List<tree>) map[x][y].tree_list);
			

		}

		while (K > 0) {

			K--;

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {
					map[i][j].eat_nut();
				}
			} // spring

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {
					map[i][j].summer_check();
				}
			} // summer
			ArrayList<tree> save= new ArrayList<>();
			
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {
					
					int sz= map[i][j].tree_list.size();
					
					for (int c=0;c<sz;c++) {
						
						tree aq= map[i][j].tree_list.poll();
						
						if (aq.age % 5 == 0) {

							for (int d = 0; d < dx.length; d++) {
								int xx = aq.x + dx[d];
								int yy = aq.y + dy[d];

								if (xx < 0 || xx >= N || yy < 0 || yy >= N) {
									
									
									continue;
								}

								map[yy][xx].tree_list.add(new tree(1, 1, xx, yy));
								
							}
							
						}
						
						
						save.add(aq);
						
					}

				}

			} // fall

			for(tree aqs : save) {
				
				map[aqs.y][aqs.x].tree_list.add(aqs);
				
			}
			
			
			
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					map[i][j].nutrition += winter_addmap[i][j];
				}
			} // winter

			// for(int i=0;i<N;i++) {
			// for(int j=0;j<N;j++) {

			// ArrayList<tree> saves = new ArrayList<>();

			// int sz=map[i][j].tree_list.size();
			// System.out.print("[");
			// for(int q=0;q<sz;q++) {

			// tree cur= map[i][j].tree_list.poll();

			// System.out.print(+cur.age+",");

			// saves.add(cur);
			// }
			// System.out.print(map[i][j].nutrition+"]");
			// for( tree as: saves) {

			// map[i][j].tree_list.add(as);

			// }
			//

			// }
			// System.out.println("");
			// }

		} // while end

		int answer = 0;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				int sz = map[i][j].tree_list.size();

				for (int s = 0; s < sz; s++) {

					tree cur = map[i][j].tree_list.poll();

					if (cur.state == 1) {

						answer++;

					}

				}

			}
		} // answer check

		System.out.println(answer);

	}

}
