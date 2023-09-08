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
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    public String toPostFix(String exp){
        for(int i = 0; i < exp.length(); i++){
            char x = exp.charAt(i);
            switch(x){
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
                    if(isAlphaNum(x)){
                        updateExpression(x);
                    }
                    else{
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

    private boolean isAlphaNum(char x){
        boolean flag = Character.isDigit(x);
        return flag;
    }
}
