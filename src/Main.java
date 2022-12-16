import codeCapriccio.array.Array;
import codeCapriccio.linkedList.MyLinkedList;

public class Main {
    public static void main(String[] args){

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.swapParis(linkedList.head);         //返回3


    }
}
