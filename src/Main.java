import codeCapriccio.DP.Change;
import codeCapriccio.greedy.LemonadeChange;
import codeCapriccio.greedy.MonotoneIncreasingDigits;
import codeCapriccio.greedy.WeeklyGame337;
import codeCapriccio.stackAndQueue.IsValid;

public class Main implements IsValid {
    public static void main(String[] args){
        Change change = new Change();
        int[] coins = {1, 2, 4};
        change.change2(5, coins);
    }
}
