import fileTruth.PostFix;
import fileTruth.Truth;

public class TruthDriver {
    public static void main(String[] args){
        Truth truth = new Truth();
        PostFix post = new PostFix();
        String s = "(p v q)->(p^q) = (p ^q) <-> ~q";
        String s1 = "p ^ q";
        String s2 = "p^q = ~(pvq)";
        boolean p = true;
        boolean q = false;
        System.out.println("Prove "  + s);
        System.out.println("\nwhere: ");
        System.out.println("    p is " + p);
        System.out.println("    q is " + q);
        System.out.println();
        boolean res = truth.solve(s, p, q, 'p','q');
        System.out.println("\nRESULT: " + String.valueOf(res).toUpperCase()  );
    }
}
