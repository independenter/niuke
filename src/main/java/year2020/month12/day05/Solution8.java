package year2020.month12.day05;

import base.Arrays;
import base.ListNode;
import lombok.val;

import java.util.List;

/**
 * <p>给定一个无序单链表，实现单链表的排序(按升序排序)。
 * <code>
 *     input: [1,3,2,4,5]
 *     output: [1,3,2,4,5]
 * </code>
 * <analysis>
 *      冒泡出每次最小的,从链表删除最小的,将链表指向最小的节点尾部,最小节点指向排序节点尾部
 * </analysis>
 *
 * @author independenter
 * @since
 */
public class Solution8 {

    private static int[] input = {1,3,3,1,3,2,4,5};
    private static Solution8 INSTANCE = new Solution8();

    public static void main(String[] args) {
        ListNode listNode = ListNode.genListNode(31821);
        listNode = INSTANCE.sortInList(listNode);
        ListNode.printListNode(listNode);
    }

    public ListNode sortInList (ListNode head) {
        ListNode min,p,q;
        int tmp;
        for (p = head;p.next != null;p=p.next){
            min = p;
            for (q = p.next;q != null;q = q.next){
                if(q.val < min.val){
                    min = q;
                }
            }
            if(min != p){
                tmp = p.val;
                p.val = min.val;
                min.val = tmp;
            }
        }
        return head;
    }

    //死循环风险public ListNode sortInList1 (ListNode head) {
    public ListNode sortInList1 (ListNode head) {
        // write code here
        ListNode dummy = new ListNode(Integer.MIN_VALUE);    // 建立哨兵，用于减少一些不必要的非空判断
        dummy.next = head;
        ListNode sortedTail = dummy;
        while (sortedTail.next != null){
            //寻找最小节点
            ListNode cur = sortedTail.next;
            ListNode min = cur;
            //记录最小的之前的节点 用于移位
            ListNode prev = sortedTail,minPrev = prev;
            while (cur != null){
                if(cur.val < min.val){
                    min = cur;
                    minPrev = prev;
                }
                prev = cur;
                cur = cur.next;
            }

            minPrev.next = min.next;
            min.next = sortedTail.next;
            //最小节点添加
            sortedTail.next = min;
            sortedTail = sortedTail.next;
        }
        return dummy.next;
    }
}
