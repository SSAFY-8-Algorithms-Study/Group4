import java.util.Scanner;
import java.util.Stack;

public class BOJ_17608_김동률 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int n = sc.nextInt();
            while(!stack.isEmpty()){
              // 비어있지 않았을 경우
                int c = stack.peek();   //가장 위에거 가져와
                if (c <= n) {
                    stack.pop();    // 안보이니 삭제
                }else {
                    break;
                }
            }
            stack.push(n);
        }
        System.out.println(stack.size());
    }
}
