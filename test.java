public class test {
    public static void main(String[] args){
        //negation
        boolean p = false;
        boolean q = true;
        String op = "->";
        System.out.println("p " + op + " q = " + exclusiveDisjunction(p, q));
    }

    static boolean negation(boolean x){
        return (!x);
    }

    static boolean disjunction(boolean x, boolean y){
        return (x||y);
    }

    static boolean conjunction(boolean x, boolean y){
        return (x && y);
    }

    static boolean conditional(boolean x, boolean y){
        if(x == y){
            return true;
        }
        else{
            return y;
        }
        
    }

    static boolean biconditional(boolean x, boolean y){
        if(x == y){
            return true;
        }
        else{
            return false;
        }
    }

    static boolean exclusiveDisjunction(boolean x, boolean y){
        if(x == y){
            return false;
        }
        else{
            return true;
        }
    }
}
