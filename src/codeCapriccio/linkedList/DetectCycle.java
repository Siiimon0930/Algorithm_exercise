package codeCapriccio.linkedList;

public interface DetectCycle {
    /*
    * 题目描述（leetcode142）：给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    * 解题思路：
    *       1）判断是否有环：快慢指针，slow每次走一步，fast每次走两步，如果有环则两个指针肯定会相遇
    *       2）找到环入口：第一次相遇的点出发和从头出发，两个指针相遇点就是环入口（有公式证明）
    * 时间复杂度：O（n）
    * */
    default ListNode detectCycle(ListNode head){
        ListNode dummyNode = new ListNode(0, head);
        ListNode fast = dummyNode, slow = dummyNode;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode meetNode = slow;
                ListNode start = dummyNode;
                while(start != meetNode){
                    start = start.next;
                    meetNode = meetNode.next;
                }
                return meetNode;
            }
        }
        return null;
    }
}
