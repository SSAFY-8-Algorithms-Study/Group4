package silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11286 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<ABS> priorityQueueLowest = new PriorityQueue<ABS>((ABS o1, ABS o2) -> {
			if (Math.abs(o1.value) > Math.abs(o2.value)) {
				return Math.abs(o1.value) - Math.abs(o2.value);
			} else if (Math.abs(o1.value) == Math.abs(o2.value)) {
				if (o1.value > o2.value) {
					return o1.value - o2.value;
				}
			}

			return -1;
		});

		for (int i = 0; i < N; i++) {
			int value = sc.nextInt();

			if (value != 0) {
				priorityQueueLowest.add(new ABS(value));
				
			} else if (value == 0) {
				if (priorityQueueLowest.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(priorityQueueLowest.poll());
				}
			}
		}
	}


	static class ABS {
		int value;

		public ABS(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return Integer.toString(value);
		}
	}
}
