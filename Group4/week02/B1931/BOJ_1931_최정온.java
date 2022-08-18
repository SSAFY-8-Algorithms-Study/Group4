package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] meetingList = new int[N][];

        StringTokenizer st;

        for (int i = 0; i < meetingList.length; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int lastTime = Integer.parseInt(st.nextToken());

            int[] time = new int[] { startTime, lastTime };

            meetingList[i] = time;
        }

        Arrays.sort(meetingList, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]; // 첫번째 기준 오름차순 > 두번째 기준 오름차순 :
                                                                        // {1,30}{2,10}{3,50}{4,20}{5,40}{6,10}{6,20}{6,30}{6,40}{6,50}
            }
        });

        int count = 0;

        int minEndTime = 0;
        
        for (int i = 0; i < meetingList.length; i++) {
            int startTime = meetingList[i][0];
            int endTime = meetingList[i][1];

            // 이전에 회의가 끝났던 시간 이후 가장 먼저 끝나는 회의 찾기
            if (startTime >= minEndTime) {
                minEndTime = endTime;
                count++;
            }
        }

        System.out.println(count);
    }
}
