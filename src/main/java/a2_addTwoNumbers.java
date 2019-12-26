
//两条链表的数倒序存（一个节点一位数），将两个链表的数相加之后也倒序存在链表返回
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8

public class a2_addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

//      存储结果的链表
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1,q = l2,curr = dummyHead;
        int carry = 0;
//        循环遍历两链表，直到两者都为空
        while(p!=null||q!=null){
//            空则为0
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = x + y + carry;
//            进位carry记录结果是否>10
            carry = sum/10;
//            当前节点存个位数结果
            curr.next = new ListNode(sum%10);
//            下个节点
            curr =  curr.next;
            if(p!=null)p=p.next;
            if(q!=null)q=q.next;
        }
//        最后的数想加完后 还有进位
        if(carry>0){
            curr.next = new ListNode(carry);
        }
//        结果为dummyHead.next
    }
}
