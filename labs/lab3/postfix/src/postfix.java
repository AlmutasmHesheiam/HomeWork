import java.util.Stack;

public class postfix {
    public static int valeupostfix(String s)
    {
        Stack<Integer>b=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c)){
                b.push(c-'0');

            }
            else
            {
                int x=b.pop();
                int y=b.pop();

            if (c=='-')
            {b.push(y-x);
            }
                if (c=='+')
                {b.push(y+x);
                }
                if (c=='*')
                {b.push(x*y);
                }
                if (c=='/')
                {b.push(y/x);
                }
        }}

      return b.pop();
    }

    public static void main(String[] args) {
        String s="138*-";
        System.out.println("postfix string="+s+"\n");

        System.out.println(valeupostfix(s));
    }
}
