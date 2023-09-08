import java.util.Scanner;
public class PemdasDriver{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Pemdas p = new Pemdas();
        String s;
        System.out.println("Ex. ((2+1)-2/2*(3+1))^2");
        System.out.print("Enter expression: ");
        s = scan.nextLine();
        System.out.println("Result: " + p.solve(s));
    }
}