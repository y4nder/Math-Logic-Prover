package fileTruth;
public class PostFix {
    private StackChar stack;
    private String expression;
    private String newExpression;

    public PostFix(){
        stack = new StackChar();
        expression = "";
        newExpression = "";
    }

    public String converToPostFix(String exp){
        expression = exp;
        // stack.show();
        return toPostFix(expression);
    }

    private void updateExpression(char x){
        newExpression += x;
    }

     String getNewExpression(){
        return newExpression;
    }

    private int checkPriority(char x){ //a method to check hierarchy in PEMDAS
        switch(x){
            case '(':
                return 0;
            case '<':
                return 1;
            case '-':
                return 2;
            case 'v':
            case 'x':
                return 3;
            case '^':
                return 4;
            case '!':
            case '~':
                return 5;
            case '=':
                return 6;
        }
        return -1;
    }

    public String toPostFix(String exp){
        for(int i = 0; i < exp.length(); i++){
            char x = exp.charAt(i);
            switch(x){
                case ' ': //skip if has space
                    break;
                case '(':
                    stack.push(x);
                    break;
                case ')':
                    char n;
                    while((n = stack.pop()) != '('){
                        updateExpression(n);
                    }
                    break;
                default:
                    int j;
                    if( (j = isOperator(x)) == -1){
                        updateExpression(x);
                    }
                    else{
                        i+=j;   //skip characters
                        while(checkPriority(stack.peek()) >= checkPriority(x)){
                            updateExpression(stack.pop());
                        }
                        stack.push(x);
                    }
                    break;
            }
        }

        //after loop has ended
        while( stack.getTop()!= 0){
            updateExpression(stack.pop());
        }
        return newExpression;
    }

    private int isOperator(char x){
        switch(x){
            case 'x': //xor
                return 2; //skip 3 characters 
            case '!':   //negation
            case '~':   //negation
            case '^':   //or
            case 'v':   //and
            case '=':   //compare
                return 0;
            case '-':   //->
                return 1; //skip 2 characters
            case '<':   //<->
                return 2;   //skip 3 characters
        }
        return -1;
    }
}
