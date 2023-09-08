public class TruthDriver {
    public static void main(String[] args){
        Truth truth = new Truth();
        String s = "(p v q)->(p^q) = (p^ q)<->~q";
        boolean p = true;
        boolean q = false;
        boolean res = truth.solve(s, p, q, 'p','q');
        System.out.println("Prove "  + s);
        System.out.println("\nwhere: ");
        System.out.println("    p is " + p);
        System.out.println("    q is " + q);
        System.out.println("\nRESULT: " + String.valueOf(res).toUpperCase()  );
    }
}
