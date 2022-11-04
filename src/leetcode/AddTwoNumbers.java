package leetcode;

import java.util.Scanner;

/**
 * @author ulfat
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1str = sc.nextLine();
        String l2str = sc.nextLine();
        ListNode l1 = parseList(l1str);
        ListNode l2 = parseList(l2str);
        ListNode l = addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.print(l.val + " ");
            l=l.next;
        }
    }

    private static ListNode parseList(String listStr) {
        String[] split = listStr.substring(1, listStr.length() - 1).split(",");
        ListNode node = new ListNode(Integer.parseInt(split[0]));
        ListNode head = node;
        for (int i = 1; i < split.length; i++) {
            node.next = new ListNode(Integer.parseInt(split[i]));
            node = node.next;
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode prev = l1;
        int c = 0;
        while(l1 != null && l2 != null) {
            c+=l1.val + l2.val;
            if (c > 9) {
                l1.val = c %10;
                c = 1;
            } else {
                l1.val = c;
                c = 0;
            }
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            c+=l1.val;
            if (c > 9) {
                l1.val = c %10;
                c = 1;
            } else {
                l1.val = c;
                c = 0;
            }
            prev = l1;
            l1 = l1.next;
        }

        while(l2 != null) {
            c+=l2.val;
            if (c > 9) {
                prev.next = new ListNode(c %10);
                c = 1;
            } else {
                prev.next = new ListNode(c);
                c = 0;
            }
            prev = prev.next;
            l2 = l2.next;
        }

        if(c > 0) {
            prev.next = new ListNode(c);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
