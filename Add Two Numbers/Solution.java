//                          PROBLEM
// You are given two non-empty linked lists representing
// two non-negative integers. The digits are stored in reverse
// order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Example:
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry_over = 0;
        boolean initialised = false;
        ListNode ret = null;
        ListNode prev = null;
        ListNode curr = null;
        while(l1 != null || l2 != null || carry_over != 0){
            if(l1 == null && l2 != null){
                curr = new ListNode((l2.val + carry_over)%10);
            }else if(l2 == null && l1 != null){
                curr = new ListNode((l1.val + carry_over)%10);
            }else if(l2 == null && l1 == null){
                curr = new ListNode(1);
                prev.next = curr;
                carry_over = 0;
            }else{
                curr = new ListNode((l1.val + l2.val + carry_over)%10);
            }
            if(l1 != null && l2 == null){
                if(l1.val + carry_over >= 10){
                    carry_over = 1;
                }else{
                    carry_over = 0;
                }
            }
            if(l2 != null && l1 == null){
                if(l2.val + carry_over >= 10){
                    carry_over = 1;
                }else{
                    carry_over = 0;
                }
            }
            if(l1 != null && l2 != null){
                if(l1.val + l2.val + carry_over >= 10){
                    carry_over = 1;
                }else{
                    carry_over = 0;
                }
            }
            if(!initialised){
                ret = curr;
                initialised = true;
            }else{
                prev.next = curr;
            }
            prev = curr;
            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }
        return ret;
    }

}