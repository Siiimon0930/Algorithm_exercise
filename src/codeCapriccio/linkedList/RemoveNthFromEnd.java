package codeCapriccio.linkedList;

public interface RemoveNthFromEnd {
    /*
    * 题目描述（leetcode19）：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    * 解题思路：双指针法，一个先走n步，而后一起往后走，前指针走到尾时，后指针就在倒数第n个位置
    * 时间复杂度：O(n)
    * */
    default ListNode removeNthFromEnd(ListNode head, int n){
        // 先判空
        if(head == null)
            return null;
        ListNode dummyNode = new ListNode(0, head);     // 虚拟头节点
        ListNode slow = dummyNode, fast = dummyNode;
        // 快指针先走n步
        for(int i = 1; i <= n; i++){
            // n不能超过链表长度
            if(fast == null)
                return null;
            fast = fast.next;
        }
        // 两个指针一起走
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
