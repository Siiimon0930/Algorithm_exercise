import codeCapriccio.array.Array;
import codeCapriccio.hashTable.ThreeSum;
import codeCapriccio.linkedList.MyLinkedList;
import codeCapriccio.stackAndQueue.IsValid;
import codeCapriccio.string.StrStr;

import java.util.Arrays;

public class Main implements IsValid {
    public static void main(String[] args){
        int[] s = {1, 2, 3, 4, 5};
        int[] ss = Arrays.copyOfRange(s, 1, 5);
        System.out.println(s);
        System.out.println(ss);
    }
}
