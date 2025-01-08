/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = calculate(l1);
        String s2 = calculate(l2);

        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);
        BigInteger res = num1.add(num2);
        String convertRes = String.valueOf(res);

        ListNode node = new ListNode(Character.getNumericValue(convertRes.charAt(convertRes.length() - 1)));
        ListNode cur = node;
        for(int i = convertRes.length() - 2; i >= 0; i--) {
            cur.next = new ListNode(Character.getNumericValue(convertRes.charAt(i)));
            cur = cur.next;
        }

        System.out.println(res);
        
        return node;
    }

    public String calculate(ListNode node) {
        StringBuilder sb = new StringBuilder ();
        while(node != null) {
            sb.append(String.valueOf(node.val));
            node = node.next;
        }
        return sb.reverse().toString();
    }
}