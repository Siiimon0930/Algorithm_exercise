import codeCapriccio.DP.Change;
import codeCapriccio.DP.CombinationSum4;
import codeCapriccio.greedy.LemonadeChange;
import codeCapriccio.greedy.MonotoneIncreasingDigits;
import codeCapriccio.greedy.WeeklyGame337;
import codeCapriccio.hashTable.IsHappy;
import codeCapriccio.linkedList.ListNode;
import codeCapriccio.linkedList.MyLinkedList;
import codeCapriccio.stackAndQueue.IsValid;
import codeCapriccio.string.ReverseStr;
import codeCapriccio.string.ReverseWords;

public class Main implements IsValid {
    public static void main(String[] args){
        String s = "the sky is blue";
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.reverseWords(s);
        System.out.println(s.substring(0, 2));
    }
}
