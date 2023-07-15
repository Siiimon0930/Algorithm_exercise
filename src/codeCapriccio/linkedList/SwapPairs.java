package codeCapriccio.linkedList;

/*
* 题意（leetcode24. 两两交换链表中的节点）：
* 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
* 解题思路：遍历模拟
*/
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        ListNode first, second;
        ListNode temp;
        while (cur.next != null && cur.next.next != null) {
            first = cur.next;
            second = cur.next.next;
            temp = second.next;
            cur.next = second;
            second.next = first;
            first.next = temp;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
