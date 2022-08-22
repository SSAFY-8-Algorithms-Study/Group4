import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2960_김동률 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<String> list = new ArrayList<>();
        for(int i=2; i<=N; i++){
            list.add(i + "");
        }
        int count = 0;
        while(true){
            //2. 작은 수 찾아 지우기
            int n = Integer.parseInt(list.get(0));    //처음 것 (가장 작은 수)
            //3. 배수 죽이기
            for(int i=0; i<list.size(); i++){
                int c = Integer.parseInt(list.get(i));
                if(c % n == 0){
                    list.remove(c + "");
                    i--;
                    count++;
                    if(count == K){
                        System.out.println(c);
                        return;
                    }
                }
            }
        }
    }
}
