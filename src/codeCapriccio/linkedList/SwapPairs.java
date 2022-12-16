package codeCapriccio.linkedList;

public interface SwapPairs {
    /*
    * 题目描述（leetcode24）：给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
    * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    * 解题思路：把链表拆为奇偶两个链表，而后通过这两个链表重新组成一个链表。
    * 时间复杂度：O（n）
    * */
    default ListNode swapParis(ListNode head){
        // 如果是空链表或只有一个结点，直接返回
        if(head == null || head.next == null)
            return head;

        ListNode odd = head, even = head.next;
        ListNode tailOdd = odd, tailEven = even;
        ListNode temp = even.next;
        int count = 1;
        // 拆分为奇偶两个链表
        while(temp != null){
            if(count % 2 == 1){
                tailOdd.next = temp;
                tailOdd = temp;
            }else {
                tailEven.next = temp;
                tailEven = temp;
            }
            count++;
            temp = temp.next;
        }
        // 两个链表结尾赋空
        tailOdd.next = null;
        tailEven.next = null;

        head = new ListNode(0, null);   // 虚拟头节点
        ListNode tail = head;
        // 拼装
        while(even != null){    // 偶链表长度 <= 奇 所以只要判断偶链表
            tail.next = even;
            even = even.next;
            tail.next.next = odd;
            odd = odd.next;
            tail = tail.next.next;
        }
        if(odd != null)         // 奇链表还剩一个的情况
            tail.next = odd;

        return head.next;

    }

    // 下面这种是纯模拟方式，多个变量处理起来细节处容易把握不住
//    public ListNode swapPairs(ListNode head) {
//
//        ListNode dummyNode = new ListNode(0);
//        dummyNode.next = head;
//        ListNode prev = dummyNode;
//
//        while (prev.next != null && prev.next.next != null) {
//            ListNode temp = head.next.next; // 缓存 next
//            prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
//            head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
//            head.next = temp;               // 将head 的 next 接上缓存的temp
//            prev = head;                    // 步进1位
//            head = head.next;               // 步进1位
//        }
//        return dummyNode.next;
//    }
}
