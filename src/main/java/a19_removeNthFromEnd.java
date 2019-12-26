//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//当删除了倒数第二个节点后，链表变为 1->2->3->5.

public class a19_removeNthFromEnd {
 public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
    boolean flag = false;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        backtrack(head, 0, n);
        if(flag)return head;
        return head.next;
    }

    public int backtrack(ListNode node,int curr,int n){
        if(node.next!=null){
            curr=backtrack(node.next,curr,n);
        }
        if(curr==n){
            ListNode node2 = node.next.next;
            node.next=node2;
            flag = true;
        }
        return ++curr;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node1 = dummy;
        ListNode node2 = dummy;
//        先移动n步，一开始在dummy开头上，所以就是在2上
        for (int i = 1; i <= n + 1; i++) {
            node1 = node1.next;
        }
//        node1在2上后，node1,node2一起移动
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
//        因为是直接=，所以改变node2也是改变head，改变dummy
        return dummy.next;
    }

    public static void main(String[] args) {
        a19_removeNthFromEnd a19 = new a19_removeNthFromEnd();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next=new ListNode(3);
        list.next.next.next=new ListNode(4);
        list.next.next.next.next=new ListNode(5);
        ListNode listNode = a19.removeNthFromEnd2(list, 2);
//        查看结果
        list.hashCode();
        System.out.println(123);
    }
}
