package codeCapriccio.linkedList;

/*
* leetcode19. 删除链表的倒数第 N 个结点: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
* 解题思路：双指针，一前一后，前面的先走n步
*/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        // fast先走n步
        for (int i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if(fast == null)
            // 如果n大于链表长度时不删除直接返回
            return head;
        // 两个一起走，当fast指向最后一个节点时，slow就指向倒数第n个节点的前一个节点
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 删除
        slow.next = slow.next.next;
        return dummy.next;
    }
}
