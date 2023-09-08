package fileTruth;
public class StackInt {
    private int[] stack;
    private int top;

    public StackInt(){
        stack = new int[20];
        top = 0;
    }

    public int getTop(){
        return top;
    }

    public void decrease(){
        top--;
    }

    public void increase(){
        top++;
    }

    public void setTop(int x){
        stack[top] = x;
    }

    public void push(int x){
        top++;
        stack[top] = x;
    }

    public int pop(){
        if(top == 0){
            return 0;
        }
        return stack[top--];
    }
    
    public int peek(){
        return stack[top];
    }

    public void show(){
        if(top == 0) return;

        for(int i = 1; i <= top; i++){
            System.out.print(stack[i] + " ");
        }
    }
}
