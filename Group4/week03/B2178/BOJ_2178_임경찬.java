import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, answer;
	public static int map[][];
	public static int visit[][];
	public static int[] dx = { 0, 0, -1, 1 };// 상 하 좌 우
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		StringTokenizer st = new StringTokenizer(a);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			a = br.readLine();
			for (int j = 0; j < a.length(); j++) {
				map[i][j] = Integer.parseInt(Character.toString(a.charAt(j)));

			}

		} // input end

		visit = new int[N][M];

		bfs(0, 0, 1);
		
		System.out.println(answer);

	}

	public static void bfs(int x, int y, int dis) {

		LinkedList<point> queue = new LinkedList<>();

		queue.add(new point(x, y, dis));

		while (!queue.isEmpty()) {

			point cur = queue.poll();
			
			if(cur.x== M-1&& cur.y==N-1) {
				
				answer= cur.dis;
				return;
			}
			

			for (int i = 0; i < dx.length; i++) {

				if (cur.x + dx[i] >= 0 && cur.x + dx[i] < M && cur.y + dy[i] >= 0 && cur.y + dy[i] < N) {// idx check

					if (map[cur.y + dy[i]][cur.x + dx[i]] == 1 && visit[cur.y + dy[i]][cur.x + dx[i]] == 0) {// delta
																												// check

						queue.add(new point(cur.x + dx[i], cur.y + dy[i], cur.dis + 1));
						visit[cur.y + dy[i]][cur.x + dx[i]] = cur.dis + 1;
						
					}

				}

			}

		}
		return ;

	}

}

class point {
	int x;
	int y;
	int dis;

	public point(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}

}