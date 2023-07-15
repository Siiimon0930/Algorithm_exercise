package codeCapriccio.linkedList;

public class MyLinkedList {
    private ListNode head;

    public MyLinkedList(ListNode head) {
        this.head = head;
    }


    /**
     * decription: 根据索引获取第i个链表值
     * @param index
     * @return int
     */
    public int get(int index){
        if(index < 0)
            return -1;
        ListNode cur = head;
        int i = 0;
        while (cur != null && i < index) {
            cur = cur.next;
            i++;
        }
        return cur == null ? -1 : cur.val;
    }

    /**
     * decription: 头插
     * @param val
     * @return void
     */
    public void addAtHead(int val){
        ListNode node = new ListNode(val, head);
        head = node;
    }

    /**
     * decription: 尾插
     * @param val
     * @return void
     */
    public void addAtTail(int val){
        ListNode node = new ListNode(val, null);
        if(head == null){
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    /**
     * decription: 按位置插入
     * @param index
     * @param val
     * @return void
     */
    public void addAtIndex(int index, int val){
        // index <= 0 时尾插
        if(index <= 0)
            addAtHead(val);
        ListNode cur = head;
        ListNode pre = head;
        int i = 0;
        while (cur != null && i < index){
            pre = cur;
            cur = cur.next;
            i++;
        }
        // 超出链表长度尾插
        if(cur == null)
            addAtTail(val);
        else {
            ListNode node = new ListNode(val, cur);
            pre.next = node;
        }
    }

    /**
     * decription: 按位置删除
     * @param index
     * @return void
     */
    public void deleteAtIndex(int index){
        // 索引无效
        if(index < 0)
            return;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, cur = head;
        int i = 0;
        while (cur != null && i < index) {
            pre = cur;
            cur = cur.next;
            i++;
        }
        // index超出长度
        if(cur == null)
            return;
        pre.next = cur.next;
    }
}
