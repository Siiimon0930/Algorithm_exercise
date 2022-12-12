package codeCapriccio.linkedList;

public interface RemoveElements {
    /*
    * 题目描述（leetcode203）：给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    * 解题思路：用两个指针去删除，一个pre，一个current
    * 时间复杂度：O(n)
    * */
//    default ListNode removeElements(ListNode head, int val){
//        if(head == null)
//            throw new NullPointerException("不要传一个空链表进来！");
//
//        // 有头节点版本
////        ListNode pre = head;
////        ListNode current = head.next;
////
////        while(current != null){
////            if(current.val == val){
////                pre.next = current.next;
////                current = current.next;
////            }else{
////                pre = current;
////                current = current.next;
////            }
////        }
//        // 无头节点版本
//        if(head == null || (head.next == null && head.val == val))
//            return null;
//
//        ListNode pre = head;
//        ListNode current = head;
//
//        while(current != null){
//            if(current.val == val){
//                pre.next = current.next;
//                current = current.next;
//            }else{
//                pre = current;
//                current = current.next;
//            }
//        }
//
//        // 最后判断第一个节点是否要移除
//        if(head.val == val)
//            head = head.next;
//
//        return head;
//    }
    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    default ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
