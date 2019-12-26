
public class a24_swapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }

    public ListNode swapPairs(ListNode head) {
//        不足两个数的处理
        if(head==null||head.next==null){
            return head;
        }
//        存好头返回这个结果
        ListNode res = new ListNode(0);
        ListNode flag = res;
        while(head!=null&&head.next!=null){
//            这个看代码没用，还是用笔自己写下流程简单
            ListNode fir = head;
            ListNode sec = head.next;
            ListNode thi = sec.next;
            fir.next = thi;
            sec.next = fir;
//            用res去存头2个数已变化后面没变化的链表
            res.next = sec;
            res = res.next.next;
//            去处理下两个数
            head = sec.next.next;
        }
        return flag.next;
    }



//    别人的递归法
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
//        取出后面的数
        ListNode next = head.next;
//        前面的数的next要连接下下个数（1.next=3,3.next=null），这里递归下去
        head.next = swapPairs(next.next);
//        将这个后面数接上本来前面的数 并返回
        next.next = head;
        return next;
    }



    public static void main(String[] args) {
        a24_swapPairs a24 = new a24_swapPairs();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);node.next.next = new ListNode(3);node.next.next.next = new ListNode(4);
        ListNode res = a24.swapPairs(node);
        System.out.println(123);
    }
}
