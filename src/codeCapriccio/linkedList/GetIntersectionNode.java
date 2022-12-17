package codeCapriccio.linkedList;

public interface GetIntersectionNode {
    /*
    * 题目描述（leetcode面试题02.07）：给你两个单链表的头节点 headA 和 headB ，
    * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    * 解题思路：总体还是双指针法，先得出两个两个的长度，长的先走n（长度差）步，而后再一起走
    * 时间复杂度：O（n）
    * */
    default ListNode getIntersectionNode(ListNode headA, ListNode headB){
        // 先判断空边界
        if(headA == null || headB == null)
            return null;
        ListNode tempA = headA, tempB = headB;  // 保存头节点
        int lengthA = 1, lengthB = 1;
        // 获取长度
        while(headA != null){
            headA = headA.next;
            lengthA++;
        }
        while(headB != null){
            headB = headB.next;
            lengthB++;
        }
        headA = tempA;
        headB = tempB;
        // 长的先走n步
        for(int i = 0; i < Math.abs(lengthA - lengthB); i++){
            if(lengthA > lengthB)
                headA = headA.next;
            else
                headB = headB.next;
        }
        // 同时走
        while(headA != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        // 到这还没return说明没交点
        return null;
    }
}
