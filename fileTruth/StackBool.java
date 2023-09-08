package fileTruth;
public class StackBool {
    private boolean[] stack;
    private int top;

    public StackBool(){
        stack = new boolean[20];
        top = 0;
    }

    public int getTop(){
        return top;
    }


    public void setTop(boolean x){
        stack[top] = x;
    }

    public void push(boolean x){
        top++;
        stack[top] = x;
    }

    public boolean pop(){
        if(top == 0){
            return false;
        }
        return stack[top--];
    }
    
    public boolean peek(){
        return stack[top];
    }

    public void show(){
        if(top == 0) return;

        for(int i = 1; i <= top; i++){
            System.out.print(stack[i] + " ");
        }
    }
}
