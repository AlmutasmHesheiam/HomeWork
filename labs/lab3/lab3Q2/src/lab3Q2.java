import java.util.Stack;

public class lab3Q2 {
    public static void removing(Stack<Integer>S)
    {
        if(S.size()>0)
        {
            S.pop();
            removing(S);
        }
    }

    public static void main(String[] args) {
        Stack<Integer>S=new Stack<>();
        S.push(1);S.push(2);S.push(3);S.push(4);
        System.out.print("BeforRemovStack ="+S+"\n");
        removing(S);
        System.out.print("AfterRemovStack ="+S+"\n");

    }
}
