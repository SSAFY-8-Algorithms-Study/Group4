import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11286_김동률 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Point> q = new PriorityQueue<>();

        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int n = sc.nextInt();
            if(n==0){
                if(q.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(q.remove().value);
                }
            }else{
                q.add(new Point(Math.abs(n), n));
            }
        }
    }
    static class Point implements Comparable<Point>{
        int abs;
        int value;

        Point(int abs, int value){
            this.abs = abs;
            this.value = value;
        }

        @Override
        public String toString() {
            return "abs : " + this.abs + ", value : " + this.value;
        }

        @Override
        public int compareTo(Point o) {
            if(this.abs >= o.abs){
                if(this.abs == o.abs){
                    if(this.value >= o.value){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    return 1;
                }
            }else{
                return -1;
            }

        }
    }
}
