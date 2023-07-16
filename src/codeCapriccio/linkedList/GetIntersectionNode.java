package codeCapriccio.linkedList;

/*
* leetcode面试题 02.07. 链表相交:
* 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
* 解题思路：获得两个的链表的长度差n，长的链表先遍历n步，而后两个一起遍历
*/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode curA = headA, curB = headB;
        // 获取A的长度
        while (curA != null){
            curA = curA.next;
            lengthA++;
        }
        // 获取B的长度
        while (curB != null){
            curB = curB.next;
            lengthB++;
        }
        // 获得长度差，并将cur归位到起始位置
        int difference = Math.abs(lengthA - lengthB);
        curA = headA;
        curB = headB;
        // 长的先走difference步
        if(lengthA > lengthB){
            for (int i = 0; i < difference; i++)
                curA = curA.next;
        }else {
            for (int i = 0; i < difference; i++)
                curB = curB.next;
        }
        // 两个一起走
        while (curA != null && curB != null){
            if(curA == curB)
                return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
