import codeCapriccio.array.Array;
import codeCapriccio.binaryTree.GetMinimumDifference;
import codeCapriccio.binaryTree.TreeNode;
import codeCapriccio.hashTable.ThreeSum;
import codeCapriccio.linkedList.MyLinkedList;
import codeCapriccio.stackAndQueue.IsValid;
import codeCapriccio.string.StrStr;

import java.util.Arrays;

public class Main implements IsValid {
    public static void main(String[] args){
        Integer[] arr= {1,0,48,null,null,12,49};
        TreeNode root = TreeNode.constructTree(arr);
        GetMinimumDifference obj = new GetMinimumDifference();
        obj.getMinimumDifference2(root);
    }
}
