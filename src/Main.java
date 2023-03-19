import codeCapriccio.greedy.WeeklyGame337;
import codeCapriccio.stackAndQueue.IsValid;

public class Main implements IsValid {
    public static void main(String[] args){
        WeeklyGame337 weeklyGame337 = new WeeklyGame337();
        weeklyGame337.evenOddBit(2);
        int[] l = {2, 4, 6};
        weeklyGame337.beautifulSubsets(l, 2);
    }
}
