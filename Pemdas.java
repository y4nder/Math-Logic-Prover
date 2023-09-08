public class Pemdas {
    private PostFix post;
    private StackInt stack;

    public Pemdas(){
        post = new PostFix();
        stack = new StackInt();
    }

    public int solve(String s){
        return Calculate(post.converToPostFix(s));
    }

    public int Calculate(String s){
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            switch(x){
                case '+':
                    sum();
                    break;
                case '-':
                    diff();
                    break;
                case '/':
                    quo();
                    break;
                case '*':
                    prod();
                    break;
                case '^':
                    pow();
                    break;
                default:
                    stack.push(Integer.parseInt(String.valueOf(x)));
            }
        }
        return stack.peek();
    }

    private void sum(){
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b + a;
        System.out.println("    " + b + " + " + a + " = " + result);
        stack.push(result);   
    }
    private void diff(){
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b - a;
        System.out.println("    " + b + " - " + a + " = " + result);
        stack.push(result);  
    }
    private void quo(){
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b / a;
        System.out.println("    " + b + " / " + a + " = " + result);
        stack.push(result);
    }
    private void prod(){
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b * a;
        System.out.println("    " + b + " * " + a + " = " + result);
        stack.push(result); 
    }

    private void pow(){
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b;
        for(int i = 1; i < a; i++){
            result *= b;
        }
        System.out.println("    " + b + " ^ " + a + " = " + result);
        stack.push(result);
    }
}