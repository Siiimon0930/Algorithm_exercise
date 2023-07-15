package codeCapriccio.linkedList;

/*
* 题意（leetcode203. 移除链表元素）：
* 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
* 解题思路：主要是要注意有没有头节点
*/
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // 边界条件
        if(head == null || (head.next == null && head.val == val))
            return null;
        ListNode front = head, cur = head.next;
        while(cur != null){
            if(cur.val == val){
                front.next = cur.next;
            }else {
                front = cur;
            }
            cur = cur.next;
        }
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        // 添加虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
