
public class a23_mergeKLists {
public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//      简单选出当前所有链表第一个中 最小的
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode ans = new ListNode(0);
//        ListNode res = ans;
//        int length = lists.length;
//        while(true) {
//            int min = Integer.MAX_VALUE;
//            int index = -1;
//            for (int i = 0; i < length; i++) {
//                if (lists[i] != null && lists[i].val < min) {
//                    min = lists[i].val;
//                    index = i;
//                }
//            }
//            if(index==-1)break;
//            ans.next = new ListNode(min);
//            ans = ans.next;
//            lists[index] = lists[index].next;
//        }
//        return res.next;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
//    空处理
        if(lists.length==0){
            return null;
        }
        return solve(lists, 0, lists.length - 1);
    }

    private ListNode solve (ListNode[] arr, int left,int right){
//        只剩下一条链表
        if(left==right){
            return arr[left];
        }
        int mid = (left + right)>>1;
//        分治法拆到两条链表
        ListNode ln = solve(arr, left, mid);
        ListNode rn = solve(arr, mid + 1, right);
        return merge(ln,rn);
    }


    private ListNode merge(ListNode node1,ListNode node2){
        if(node1==null) return node2;
        if(node2==null) return node1;
//      合并两条链表  直接小的作为链表，后面其他的接上去
        if(node1.val<node2.val){
            node1.next=merge(node1.next,node2);
            return node1;
        }else{
            node2.next=merge(node1,node2.next);
            return node2;
        }
    }

    public static void main(String[] args) {
        a23_mergeKLists a23 = new a23_mergeKLists();
        ListNode l1 = new ListNode(1);l1.next=new ListNode(4);l1.next.next=new ListNode(5);
        ListNode l2 = new ListNode(1);l2.next=new ListNode(3);l2.next.next=new ListNode(4);
        ListNode l3 = new ListNode(2);l3.next=new ListNode(6);
        ListNode l4 = new ListNode(2);l3.next=new ListNode(6);
        ListNode[] lists = new ListNode[4];
        lists[0]=l1;lists[1]=l2;lists[2]=l3;lists[3]=l4;
        ListNode res = a23.mergeKLists(lists);
        System.out.println(res);
    }
}
