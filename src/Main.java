import codeCapriccio.greedy.LemonadeChange;
import codeCapriccio.greedy.WeeklyGame337;
import codeCapriccio.stackAndQueue.IsValid;

public class Main implements IsValid {
    public static void main(String[] args){
        LemonadeChange le = new LemonadeChange();
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        le.lemonadeChange(bills);
    }
}
