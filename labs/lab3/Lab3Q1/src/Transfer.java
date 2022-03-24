
import java.util.Stack;

/**
 */
public class Transfer {


    public static Stack<Integer> transfer(Stack<Integer> S, Stack<Integer> T){

        while (S.size()>0)
        {
            int x=S.pop();
            T.push(x);

        }
return T;

    }

    public static void main(String[] args) {


        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();
        S.push(1);S.push(2);S.push(3);S.push(4);

System.out.print("Stack S="+S+"\n");
        System.out.print("Stack T="+transfer(S,T));


    }



}
