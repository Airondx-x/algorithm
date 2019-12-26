//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4

public class a21_mergeTwoLists {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (l1!=null&&l2!=null){
            int v1 = l1.val;
            int v2 = l2.val;
            if(v1>=v2){
                res.next = new ListNode(v2);
                res = res.next;
                l2 = l2.next;
            }else {
                res.next = new ListNode(v1);
                res = res.next;
                l1 = l1.next;
            }
        }
        if(l1==null)
            res.next = l2;
        else
            res.next = l1;

        return head.next;
    }
    public static void main(String[] args) {
        a21_mergeTwoLists a21 = new a21_mergeTwoLists();
        ListNode l1 = new ListNode(1);l1.next = new ListNode(2);l1.next.next=new ListNode(4);
        ListNode l2 = new ListNode(1);l2.next = new ListNode(3);l2.next.next=new ListNode(4);
        ListNode listNode = a21.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }
}
