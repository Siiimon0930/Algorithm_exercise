package codeCapriccio.linkedList;

/*
* leetcode142. 环形链表 II:
* 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
* 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
* 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
* 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。不允许修改 链表。
* 解题思路：快慢指针，一个步长2，一个1，两个若不能相遇则无环，若相遇，则在相遇点开始出发，另一个从头节点出发，二者相遇的位置就是环的入口
*/
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        // 注意判断条件fast.next不要为空
        while (fast != null && fast.next != null) {
            // 这两句不能放在相遇判断后面，因为一开始都是指向head本来就时相遇的。
            slow = slow.next;
            fast = fast.next.next;
            // 当二者相遇
            if(slow == fast){
                slow = head;
                // 一个从头走，一个从相遇点走
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
