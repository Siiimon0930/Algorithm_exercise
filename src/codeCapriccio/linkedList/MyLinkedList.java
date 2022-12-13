package codeCapriccio.linkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList(){
        this.size = 0;
        this.head = new ListNode(0);    // 虚拟头节点
    }

    // get by index
    public int get(int index){
        if(index < 0 || index >= size)
            return -1;
        ListNode temp = head;
        for(int i = 0; i <= index; i++)
            temp = temp.next;
        return temp.val;
    }

    // add at head
    public void addAtHead(int val){
        ListNode newNode = new ListNode(val, head.next);
        head.next = newNode;
        size++;
    }

    // add at tail
    public void addAtTail(int val){
        ListNode tailNode = head;
        ListNode newNode = new ListNode(val);
        for(int i = 0; i < size; i++)
            tailNode = tailNode.next;
        tailNode.next = newNode;
        size++;
    }

    // add at index
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。
    // 如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val){
        if(index > size)
            return;
        else if (index == size) {
            addAtTail(val);
            return;
        } else if (index <= 0) {
            addAtHead(val);
            return;
        }else {
            ListNode pre = head;
            for(int i = 0; i < index; i++)
                pre = pre.next;
            ListNode newNode = new ListNode(val, pre.next);
            pre.next = newNode;
            size++;
        }
    }

    // delete at index
    public void deleteAtIndex(int index){
        if(index < 0 || index >= size)
            return;
        ListNode pre = head;
        for(int i = 0; i < index; i++)
            pre = pre.next;
        pre.next = pre.next.next;
        size--;
    }


}
