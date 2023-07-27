import codeCapriccio.stackAndQueue.IsValid;
import codeCapriccio.string.ReverseWords;

public class Main {
    public static void main(String[] args){
        String s = "the sky is blue";
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.reverseWords(s);
        System.out.println(s.substring(0, 2));
    }
}
