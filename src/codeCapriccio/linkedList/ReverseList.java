package codeCapriccio.linkedList;

/*
* 题意（leetcode206. 反转链表）：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
* 解题思路：头插法
*/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // 先创建一个虚拟头节点
        ListNode dummy = new ListNode(-1, null);
        ListNode temp;
        while(head != null){
            temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        return dummy.next;
    }

}
