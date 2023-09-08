package fileTruth;
public class testPostFix {
    public static void main(String[] args){
        PostFix post = new PostFix();
        String exp = "~(p xor ~q)";
        System.out.println(post.converToPostFix(exp));
    }
}
