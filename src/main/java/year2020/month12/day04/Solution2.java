package year2020.month12.day04;

import base.ListNode;
import cn.hutool.core.lang.Console;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> 合并 k个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
 *
 * <code>
 *     input: [{1,2,3},{4,5,6,7}]
 *     output: {1,2,3,4,5,6,7}
 * </code>
 *
 * @author independenter
 * @since
 */
public class Solution2 {

    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(ListNode.genListNode(new int[]{1,2,3}));
        lists.add(ListNode.genListNode(new int[]{4,5,6,7}));
        lists.add(ListNode.genListNode(new int[]{0}));
        ListNode listNode = new Solution2().mergeKLists(lists);
        Console.log(listNode);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return mergeKLists1(lists);
    }

    public static ListNode mergeKLists1(ArrayList<ListNode> lists) {
        //凑成偶数
        if(lists.size() >> 1 << 1 != lists.size()){
            lists.add(null);
        }
        ListNode header = null;
        for (int i = 0; i < lists.size(); i++) {
            header = mergeTwoList(header,lists.get(i));
        }
        return header;
    }

    //分制法
    public static ListNode mergeTwoList(ListNode node1,ListNode node2){
        if(node2 == null || node1 == null){
            return node1 == null ? node2 : node1;
        }
        ListNode head = null,tail = null,next=null;
        while (node1 != null && node2 != null){
            if(node1.val > node2.val){
                next = node2;
                node2 = node2.next;
            }else{
                next = node1;
                node1 = node1.next;
            }

            next.next = null;
            if(head == null){
                head = tail = next;
            }else{
                tail.next=next;
                tail=next;
            }
        }
        if(node1 != null ) {
            tail.next = node1;
        }
        if(node2 != null ) {
            tail.next = node2;
        }
        return head;
    }
}
