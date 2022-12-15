package codeCapriccio.linkedList;

public interface ReverseList {
    /*
    * 题目描述（leetcode206）：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    * 思路：遍历一遍，并进行头插
    * 时间复杂度：O(n)
    * */
    default ListNode reverseList(ListNode head){
        ListNode pred = head;
        ListNode temp;
        head = null;
        while(pred != null){
            temp = pred.next;
            pred.next = head;
            head = pred;
            pred = temp;
        }
        return head;
    }
}
