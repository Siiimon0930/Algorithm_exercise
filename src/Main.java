import codeCapriccio.DP.Change;
import codeCapriccio.DP.CombinationSum4;
import codeCapriccio.greedy.LemonadeChange;
import codeCapriccio.greedy.MonotoneIncreasingDigits;
import codeCapriccio.greedy.WeeklyGame337;
import codeCapriccio.linkedList.ListNode;
import codeCapriccio.linkedList.MyLinkedList;
import codeCapriccio.stackAndQueue.IsValid;

public class Main implements IsValid {
    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList(new ListNode(1));
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }
}
