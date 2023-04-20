import codeCapriccio.DP.Change;
import codeCapriccio.DP.CombinationSum4;
import codeCapriccio.greedy.LemonadeChange;
import codeCapriccio.greedy.MonotoneIncreasingDigits;
import codeCapriccio.greedy.WeeklyGame337;
import codeCapriccio.stackAndQueue.IsValid;

public class Main implements IsValid {
    public static void main(String[] args){
        CombinationSum4 con = new CombinationSum4();
        int[] coins = {1, 2, 3};
        con.combinationSum4(coins, 4);
    }
}
