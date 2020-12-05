package base;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;

/**
 * <p>
 *
 * @author independenter
 * @since
 */
public class ListNode{

    public int val;
    public ListNode next;
    public ListNode(Integer integer) {
        this.val = integer;
    }

    public ListNode(Integer integer, ListNode next) {
        this.val = integer;
        this.next = next;
    }

    public static ListNode genListNode(int len){
        ListNode h = null;
        System.out.print("gen===>");
        for (int i = 0; i < len; i++) {
            int random = RandomUtil.randomInt(len);
            System.out.print(" " + random);
            ListNode newListNode = new ListNode(random);
            if (h == null){
                h = newListNode;
            }else{
                newListNode.next = h;
                h = newListNode;
            }
        }
        Console.log("");
        return h;
    }

    public static ListNode genListNode(int[] item){
        ListNode h = null;
        System.out.print("gen===>");
        for (int i = item.length - 1; i >=0 ; i--) {
            System.out.print(" " + item[i]);
            ListNode newListNode = new ListNode(item[i]);
            if (h == null){
                h = newListNode;
            }else{
                newListNode.next = h;
                h = newListNode;
            }
        }
        Console.log("");
        return h;
    }

    public static void printListNode(ListNode head){
        System.out.print("print ==>");
        while (head != null){
            System.out.print(" " + head.val);
            head = head.next;
        }
    }
}
