
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//给定这个链表：1->2->3->4->5
//当 k = 2 时，应当返回: 2->1->4->3->5
//当 k = 3 时，应当返回: 3->2->1->4->5
public class a25_reverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    假设k是3
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
//            后面已经处理过的数，（4.5）
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
//                先保存好除了head的后面数（2.3.4.5）
                ListNode tmp = head.next;
//                直接head接上cur（1.4.5），是符合要求的数了
                head.next = cur;
//                更新这个cur（1.4.5），下次再接
                cur = head;
//                已经处理了一个数（2.3.4.5）
                head = tmp;
            }
//          这里多了这一步，不返回cur的原因是，最后一轮少于3个数的时候，是直接返回原本的节点，
//          就是head，这个时候cur已经next到null了，所以配合递归语法，head=cur再返回head
            head = cur;
        }
        return head;
    }

//      尾插法
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
//        拿出头尾来操作head本身
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }
//            不足k个就保持原样输出
            if (tail == null) break;
            ListNode head1 = pre.next;
            while (pre.next != tail) {
//                得到头
                ListNode cur = pre.next;
//                head去掉头
                pre.next = cur.next;
//                头接上后续
                cur.next = tail.next;
//                head的尾巴接上刚才的 头+后续，完成一次尾插
                tail.next = cur;
            }
            pre = head1;
            tail = head1;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        a25_reverseKGroup a25 = new a25_reverseKGroup();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode listNode = a25.reverseKGroup(list, 3);
        System.out.println(123);
    }
}
