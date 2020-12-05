package year2020.month12.day05;

import base.ListNode;

/**
 * <p>判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * O(1)空间复杂度
 *
 * @author independenter
 * @since
 */
public class Solution1 {

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while(p!=null && p.next!=null){
            p = p.next.next;
            q = q.next;
            if(p==q){
                return true;
            }

        }
        return false;
    }
}
