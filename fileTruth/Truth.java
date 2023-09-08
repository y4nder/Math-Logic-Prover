package fileTruth;
public class Truth {
    private PostFix post;
    private StackBool stack;

    public Truth(){
        post = new PostFix();
        stack = new StackBool();
    }

    public boolean solve(String s, boolean x, boolean y, char p, char q){
        return Calculate(post.converToPostFix(s), x, y, p, q);
    }

    public boolean Calculate(String s, boolean x, boolean y, char p, char q){
        for(int i = 0; i < s.length(); i++){
            char n = s.charAt(i);
            switch(n){
                case 'x':
                    xor();
                    break;
                case '!':
                case '~':
                    not();
                    break;
                case '^':
                    and();
                    break;
                case 'v':
                    or();
                    break;
                case '-':
                    ifThen();
                    break;
                case '<':
                    ifAndOnlyIf();
                    break;
                case '=':
                    compare();
                    break;
                default:
                    stack.push(assign(n, x, y, p, q));
            }
        }
        return stack.peek();
    }

    private void xor(){
        boolean a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = exclusiveDisjunction(b, a);
        stack.push(result);
    }

    private void not(){
        boolean a, result;
        a = stack.pop();
        result = negation(a);
        stack.push(result);
    }

    private void and(){
        boolean a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = conjunction(b, a);
        stack.push(result);
    }

    private void or(){
        boolean a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = disjunction(b, a);
        stack.push(result);
    }

    private void ifThen(){
        boolean a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = conditional(b, a);
        stack.push(result);
    }

    private void ifAndOnlyIf(){
        boolean a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = biconditional(b, a);
        stack.push(result);
    }

    private void compare(){
        boolean a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = equal(b, a);
        stack.push(result);
    }

    //truth table methods
    private boolean equal(boolean x, boolean y){
        if(x == y) return true;
        else return false;
    }

    private boolean exclusiveDisjunction(boolean x, boolean y){
        if(x == y){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean negation(boolean x){
        return (!x);
    }

    private boolean conjunction(boolean x, boolean y){
        return (x && y);
    }

    private boolean disjunction(boolean x, boolean y){
        return (x||y);
    }

    private boolean conditional(boolean x, boolean y){
        if(x == y){
            return true;
        }
        else{
            return y;
        }
        
    }

    private boolean biconditional(boolean x, boolean y){
        if(x == y){
            return true;
        }
        else{
            return false;
        }
    }

    //assigning the boolean value for the character found
    private boolean assign(char n, boolean x, boolean y, char p, char q){
        if(n == p){
            return x;
        }
        else{
            return y;
        }
    }
    

}